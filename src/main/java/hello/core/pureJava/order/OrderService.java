package hello.core.pureJava.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);


}
