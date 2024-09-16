package hello.core.useSpring.member;

public interface MemberRepository {
    public void save(Member member);
    public Member findMember(int id);
}
