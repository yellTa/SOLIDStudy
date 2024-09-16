package hello.core.pureJava.member;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long memberId);
}
