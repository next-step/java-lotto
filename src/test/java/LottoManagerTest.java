import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoManagerTest {

	@Test
	void calculateRevenueTest(){
		assertThat(LottoManager.calculateRevenue( ()->10000, 15000))
			.isEqualTo(0.67); // 0.6666666에서 반올림
	}
}
