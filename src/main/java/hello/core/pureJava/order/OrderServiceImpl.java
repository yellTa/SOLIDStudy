package hello.core.pureJava.order;

import hello.core.pureJava.discount.DiscountPolicy;
import hello.core.pureJava.member.Member;
import hello.core.pureJava.member.MemberRepository;

public class OrderServiceImpl implements OrderService{
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
////    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //Order Service입장은 디스카운트가 모르겠음
    //그러니까 discountPolicy로 보내는 거임
    //discorund Policy라는게 없었다면? 이건 단일책임 원칙을 잘 챙긴 사례라고 하면됨
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discount = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discount);
    }
}
