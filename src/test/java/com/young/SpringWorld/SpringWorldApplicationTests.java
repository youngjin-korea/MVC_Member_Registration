package com.young.SpringWorld;

import com.young.SpringWorld.domain.Member;
import com.young.SpringWorld.repository.MemberMemoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringWorldApplicationTests {
	MemberMemoryRepository repository = new MemberMemoryRepository();

	@Test
	public void save() {
		Member member = new Member();
	}

}
