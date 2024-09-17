package hello.core.serviceLocator;

public class OrderProcessor implements IOrderProcessor {
    @Override
    public void process(Order order) {
        //주문이 맞는지 체크하고 보내준다고 가정하자
        //이러면 에러가 난다.


        //resolve를 통해서 동적으로 의존성을 해결한다.
        //아래의 코드는 IOrderValidator클래스에 해당하는 서비스를 찾는 메소드이다.
        IOrderValidator validator = Locator.resolve(IOrderValidator.class);

        if (validator.validate(order)) {// 주문이 유효한 경우(다 유효하게 일단 짜놓음)

            //IOrderShipper에 해당하는 서비스 객체를 Locator를 이용해 뽑아온다.
            IOrderShipper shipper = Locator.resolve(IOrderShipper.class);
            shipper.ship(order);
        }
    }
}
