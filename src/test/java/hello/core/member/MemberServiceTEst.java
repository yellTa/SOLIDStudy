package hello.core.member;

import hello.core.Member.Grade;
import hello.core.Member.Member;
import hello.core.Member.MemberService;
import hello.core.Member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTEst {
    MemberService memberService = new MemberServiceImpl();\

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
