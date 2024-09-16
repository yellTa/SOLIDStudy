package hello.core.useSpring.member;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemoryMemberRepository implements MemberRepository{
    Map<Integer, Member> store = new HashMap<>();
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findMember(int id) {
        return store.get(id);
    }
}
