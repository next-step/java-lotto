package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MatchTypeTest {

	@Test
	@DisplayName("보너스 숫자가 일치 해야지만 참이다.")
	public void checkMatchTypeOfTrue() {
		MatchType result = MatchType.TRUE;
		boolean bonusMatch1 = result.isBonusMatch(false);

		assertThat(bonusMatch1).isFalse();

		boolean bonusMatch2 = result.isBonusMatch(true);

		assertThat(bonusMatch2).isTrue();
	}

	@Test
	@DisplayName("보너스 숫자가 불일치 해야지만 참이다.")
	public void checkMatchTypeOfFalse() {
		MatchType result = MatchType.FALSE;
		boolean bonusMatch1 = result.isBonusMatch(false);

		assertThat(bonusMatch1).isTrue();

		boolean bonusMatch2 = result.isBonusMatch(true);

		assertThat(bonusMatch2).isFalse();
	}

	@Test
	@DisplayName("보너스 숫자가 일치여부 상관없이 참이다.")
	public void checkMatchType() {
		MatchType result = MatchType.NONE;
		boolean bonusMatch1 = result.isBonusMatch(false);

		assertThat(bonusMatch1).isTrue();

		boolean bonusMatch2 = result.isBonusMatch(true);

		assertThat(bonusMatch2).isTrue();
	}

}