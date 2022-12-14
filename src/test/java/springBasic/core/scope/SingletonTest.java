package springBasic.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    @DisplayName("")
    public void singletonBeanFind() {
        // given
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingtonBean.class);

        // when
        SingtonBean singletonBean1 = ac.getBean(SingtonBean.class);
        SingtonBean singletonBean2 = ac.getBean(SingtonBean.class);
        System.out.println("singletonBean1 = " + singletonBean1);
        System.out.println("singletonBean2 = " + singletonBean2);

        // then
        assertThat(singletonBean1).isSameAs(singletonBean2);
        ac.close();

    }

    @Scope("singleton")
    static class SingtonBean {

        @PostConstruct
        public void init() {
            System.out.println("SingtonBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("SingtonBean.destroy");
        }

    }
}
