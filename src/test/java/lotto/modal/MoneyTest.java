package lotto.modal;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MoneyTest {

	@Test
	void initExceptionTest() {

		/* IllegalArgumentException 종류
		 *
		 * 1. null
		 * 2. Empty String
		 * 3. 1000 > money
		 */
		assertThatIllegalArgumentException().isThrownBy(() -> new GameManual(null));
		assertThatIllegalArgumentException().isThrownBy(() -> new GameManual(""));
		assertThatIllegalArgumentException().isThrownBy(() -> new GameManual("  "));
		assertThatIllegalArgumentException().isThrownBy(() -> new GameManual("900"));
	}

	@Test
	void initMoneyTest() {

		GameManual money = new GameManual("10000");

		assertThat(money).isEqualTo(new GameManual("10000"));
	}
}
