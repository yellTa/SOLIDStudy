package hello.core.Member;

public interface MemberService {

    //id조회
    void join(Member member);
    //id 찾기
    Member findMember(Long memberId);


}
