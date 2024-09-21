package hello.core.useSpring.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {
//AutoWired를 사용한 생성자 주입
//이 부분을 Dependency Injection이라고 부르며 생성자 주입을 수행하게 되면
    // SOLID의 추상화에만 의존하는 DIP원칙도 지키게 되는 격이다.

    @Autowired
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override

    public void register(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMemberById(int id) {
        return memberRepository.findMember(id);
    }
}
