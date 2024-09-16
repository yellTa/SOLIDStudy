package hello.core.useSpring.member;

public interface MemberService {
    public void register(Member member);

    public Member findMemberById(int id);
}
