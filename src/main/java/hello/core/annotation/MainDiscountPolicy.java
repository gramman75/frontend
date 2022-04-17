package hello.core.annotation;


import org.springframework.context.annotation.Primary;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Primary
public @interface MainDiscountPolicy {
}
