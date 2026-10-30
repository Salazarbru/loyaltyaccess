package com.loyaltyaccess;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@EnabledIfEnvironmentVariable(named = "SUPABASE_DB_URL", matches = ".+")
class LoyaltyaccessApplicationTests {

	@Test
	void contextLoads() {
	}

}
