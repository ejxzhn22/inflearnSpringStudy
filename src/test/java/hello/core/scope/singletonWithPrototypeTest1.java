package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class singletonWithPrototypeTest1 {

    @Test
    void prototypeFind() {

    }

    @Scope("prototype")
    static class PrototypeBean {
        private  int count =0;

        public void addCount() {
            count++;
        }

        public int getCount() {
            return count;
        }

        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init " + this);
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }
    }
}
