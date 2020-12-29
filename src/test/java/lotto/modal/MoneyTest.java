package lotto.modal;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

	@Test
	@DisplayName("돈: 생성 실패 Exception Test")
	void initExceptionTest() {
		/* IllegalArgumentException 종류
		 *
		 * 1. 음수
		 * 2. 1000 > money
		 */
		assertThatIllegalArgumentException().isThrownBy(() -> Money.generateMoney(-10900));
		assertThatIllegalArgumentException().isThrownBy(() -> Money.generateMoney(900));
	}

	@Test
	@DisplayName("돈: 생성 테스트")
	void initMoneyTest() {
		Money money = Money.generateMoney(10000);
		assertThat(money).isEqualTo(Money.generateMoney(10000));
	}
}
