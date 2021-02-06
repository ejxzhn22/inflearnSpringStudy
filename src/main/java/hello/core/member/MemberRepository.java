package hello.core.member;

public interface MemberRepository {

    //회원 저장
    void save(Member member);

    //id로 회원조회
    Member findById(Long memberId);
}
