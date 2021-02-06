package hello.core.member;

public interface MemberService {

    // 회원가입
    void join(Member member);

    // 아이디로 회원 조회회
   Member findMember(Long memberId);
}
