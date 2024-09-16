package hello.core.pureJava.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    //실무에서는 concurrentHash맵 써야됨
    //동시성 이슈 때문에 일단 이정도만 알고있기
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(),member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
