package hello.core.member;

import hello.core.Appconfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService;

    @BeforeEach
    public void before(){
        Appconfig app = new Appconfig();
        memberService = app.memberService();
    }


    //test를 잘 작성하는 것이 중요함
    @Test
    void join(){
        //given
        Member member = new Member(1L, "MemberA", Grade.VIP);
        //when

        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        //then
        Assertions.assertThat(member).isEqualTo(findMember);


    }
}
