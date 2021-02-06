package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach   // 각각 테스트실행 전에 실행
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        //given 환경이 주어졌을 때
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when 했을 때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then 이렇게 된다.
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
