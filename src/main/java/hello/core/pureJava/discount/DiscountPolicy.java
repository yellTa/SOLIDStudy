package hello.core.pureJava.discount;

import hello.core.pureJava.member.Member;

public interface DiscountPolicy {
    /*
    * @return 할인 대상금액
    * */
    int discount(Member member, int price);

}
