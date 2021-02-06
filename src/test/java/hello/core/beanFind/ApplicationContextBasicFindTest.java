package hello.core.beanFind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }

    @Test
    @DisplayName("이름없이 타입으로만 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    // 인터페이스를 조회하면 구현체가 조회가 된다.
    }

    @Test
    @DisplayName("구체타입으로 조회")
    void findBeanByName2() {
        MemberServiceImpl memberService = ac.getBean("memberService",MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
        //역할과 구현을 구분해야함 , 역할에 의존해야함  이건 구현에 의존한것 -> 좋지않음  유연성이 떨어진다
    }

    //실패테스트
    @Test
    @DisplayName("빈 이름으로 조회 x")
    void findBeanByNamex() {
        //ac.getBean("xxxx", MemberService.class);

        //예외가 뜨면 성공
        assertThrows(NoSuchBeanDefinitionException.class,
                () ->ac.getBean("xxxx", MemberService.class));
    }


}
