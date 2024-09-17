package hello.core.serviceLocator;

public class OrderApp {
    public static void main(String[] args) {

        // 필요한 서비스 등록
        //서비스릉 등록하지 않으면 Locator 맵에 저장된 서비스가 없어서 에러가 남
        //왜? 해당하는 객체에 맞는 서비스를 리턴할 수 없으니까
//        Locator.register(IOrderValidator.class, () -> new IOrderValidator());
//        Locator.register(IOrderShipper.class, () -> new IOrderShipper());

        Order order = new Order(1, "오오오",1234);
        OrderProcessor orderProcessor = new OrderProcessor();

        orderProcessor.process(order);
    }
}
