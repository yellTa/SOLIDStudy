package hello.core.Member;

//구현체가 하나만 있을 때는 관례상 Impl이라고 씀
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepsitory  = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        //다형성에 의해서
        memberRepsitory.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepsitory.findById(memberId);
    }
}
