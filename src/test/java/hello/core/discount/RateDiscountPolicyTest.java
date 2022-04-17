package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10%의 할인 적용")
    void vio_o() {

        Member member = new Member( 1L, "memberA", Grade.VIP);
        int discount = discountPolicy.discount(member, 10000);
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("BASIC는 rate할인 미적용")
    void vip_x(){

        Member member = new Member( 2L, "memberB", Grade.BASIC);
        int discount = discountPolicy.discount(member, 10000);
        assertThat(discount).isEqualTo(0);

    }
}