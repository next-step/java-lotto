package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class LottoOrderTest {


	@DisplayName("수동구매 요청 수 보다 실제 수동번호 셋트가 부족하게 입려된 경우")
	@Test
	void lessThanInputManualCount() {
		int investment = 10000;
		int manualCount = 3;
		LottoOrder order = new LottoOrder(investment, manualCount);

		assertThat(order.verify()).isFalse();
	}

	@DisplayName("수동구매비용이 투자금을 초과하는 경우")
	@Test
	void manualCountOverInvestment() {
		int investment = 1000;
		int manualCount = 3;

		assertThatIllegalArgumentException().isThrownBy(() -> {
			new LottoOrder(investment, manualCount);
		});

	}
}