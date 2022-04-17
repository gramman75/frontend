package hello.core.scope;

import ch.qos.logback.core.net.server.Client;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class ScopeTest {

    @Test
    public void scopeTest(){
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);

        ClientBean client1 = ac.getBean(ClientBean.class);
        int count1 = client1.logic();

        ClientBean client2 = ac.getBean(ClientBean.class);
        int count2 = client2.logic();

        Assertions.assertThat(count1).isEqualTo(1);
        Assertions.assertThat(count2).isEqualTo(1);


    }

    @Scope
    static class ClientBean {


        @Autowired
        private ObjectProvider<PrototypeBean> prototypeBeanProvider;

//        public ClientBean(ObjectProvider<PrototypeBean> prototypeBean){
//            this.prototypeBean = prototypeBean.getObject();
//        }

        public int logic(){
            PrototypeBean prototypeBean = prototypeBeanProvider.getObject();
            prototypeBean.addCount();
            return prototypeBean.getCount();
        }
    }

    @Scope("prototype")
    static class PrototypeBean{

        int count = 0;


        public void addCount(){
            count++;
        }

        public int getCount(){
            return count;
        }

    }
}
