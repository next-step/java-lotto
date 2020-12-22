package lotto.modal;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameConditionTest {

	@Test
	void initExceptionTest() {

		/* IllegalArgumentException 종류
		 *
		 * 1. null
		 * 2. Empty String
		 * 3. 1000 > money
		 */
		assertThatIllegalArgumentException().isThrownBy(() -> new GameCondition(null));
		assertThatIllegalArgumentException().isThrownBy(() -> new GameCondition(""));
		assertThatIllegalArgumentException().isThrownBy(() -> new GameCondition("  "));
		assertThatIllegalArgumentException().isThrownBy(() -> new GameCondition("900"));
	}

	@Test
	void initMoneyTest() {

		GameCondition money = new GameCondition("10000");

		assertThat(money).isEqualTo(new GameCondition("10000"));
	}
}
