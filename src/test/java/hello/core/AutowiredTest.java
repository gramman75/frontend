package hello.core;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {



   @Test
   public void AutowiredOption(){
      AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
   }


   static class TestBean{
      @Autowired(required = false)
      public void noBean(Member member){
         System.out.println("noBean= " + member);
      }

      @Autowired
      public void nullBean(@Nullable Member member){
         System.out.println("nullBean = " + member);
      }


      @Autowired
      public void optionBean(Optional<Member> member){
         System.out.println("optionBean= " + member);
      }

   }


}
