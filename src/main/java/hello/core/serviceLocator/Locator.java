package hello.core.serviceLocator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Locator {
    private static final Map<Class<?>, Supplier<?>> services = new HashMap<>();

    // 서비스 등록
    public static <T> void register(Class<T> type, Supplier<T> resolver) {
        services.put(type, resolver);
        //미리 등록된 서비스를 HashMap에서 찾아서 반환한다.
        //객체를 요청할 때마다 Supplier가 등록된 로직에 따라 객체를 생성해 의존성을
        //동적으로 해결하는 방식이다.
        //이 방식으로 여러 클래스의 인스턴스를 상황에 맞게 생성할 수 있다.
    }

    // 서비스 해제
    @SuppressWarnings("unchecked")
    public static <T> T resolve(Class<T> type){
        /*resolve 메서드는 호출할 때 원하는 클래스 타입을 인자로 받아서 return함*/
        //Services 맵에서 해당 타입의 Supplier<?> 객체를 찾는다.
        Supplier<?> supplier = services.get(type);
        //만약에 null이 아니다?
        if (supplier != null) {
            //supplier에서 객체를 return
            //여러개 등록된 경우 가장 마지막으로 등록된 서비스를 반환한다.
            //HashMap이라서 마지막으로 등록된 상태를 먼저씀 왜냐? Map형태니까
            //ex) OrderService : A -> put이 됨
            // OrderServie : B - > A가 B로 바뀜
            // OrderService를 리턴할땐 B서비스로 리턴함
            return (T) supplier.get();
        }
        //null이면 맞는 서비스를 찾아서 return할 수 없음 에러발생
        throw new IllegalArgumentException("Service not registered: " + type.getName());
    }

    // 모든 서비스 초기화
    public static void reset() {
        services.clear();
    }
}
