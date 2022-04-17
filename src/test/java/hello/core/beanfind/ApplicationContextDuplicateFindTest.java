package hello.core.beanfind;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextDuplicateFindTest {


    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(DuplicateConfig.class);


    @Test
    @DisplayName("Type으로 조회시 중복 발생.")
    void findByTypeDuplicate(){
        assertThrows(NoUniqueBeanDefinitionException.class, () ->{
            ac.getBean(DiscountPolicy.class);
        });
    }

    @Test
    @DisplayName("Type으로 조회시 건수확인.")
    void findByTypeAll() {
        Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);

        for (String key : beansOfType.keySet()){
            DiscountPolicy discountPolicy = beansOfType.get(key);
            System.out.println("discountPolicy = " + discountPolicy);
        }

        assertThat(beansOfType.size()).isEqualTo(2);


    }

    static class DuplicateConfig{

        @Bean
        public DiscountPolicy rateDiscountPol (){
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy fixDiscountPolicy(){
            return new FixDiscountPolicy();
        }
    }
}
