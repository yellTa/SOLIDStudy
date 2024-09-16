package hello.core.useSpring.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest // Spring 컨테이너를 불러오는 설정
class MemberServiceImplTest {
    @Autowired
    private MemberService memberService;

    @Test
    public void register(){
        Member member = new Member(1, "member1", Grade.VIP);

        memberService.register(member);

        Member findMember = memberService.findMemberById(1);

        assertEquals(member, findMember);
    }

}