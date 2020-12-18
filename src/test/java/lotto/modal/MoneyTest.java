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
		assertThatIllegalArgumentException().isThrownBy(() -> new Money(null));
		assertThatIllegalArgumentException().isThrownBy(() -> new Money(""));
		assertThatIllegalArgumentException().isThrownBy(() -> new Money("  "));
		assertThatIllegalArgumentException().isThrownBy(() -> new Money("900"));
	}

	@Test
	void initMoneyTest() {

		Money money = new Money("10000");

		assertThat(money).isEqualTo(new Money("10000"));
	}
}
