package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MatchBonusTypeTest {

	@Test
	@DisplayName("보너스 숫자가 일치 해야지만 참이다.")
	public void checkMatchTypeOfTrue() {
		MatchBonusType result = MatchBonusType.TRUE;
		boolean bonusMatch1 = result.isBonusMatch(false);

		assertThat(bonusMatch1).isFalse();

		boolean bonusMatch2 = result.isBonusMatch(true);

		assertThat(bonusMatch2).isTrue();
	}

	@Test
	@DisplayName("보너스 숫자가 불일치 해야지만 참이다.")
	public void checkMatchTypeOfFalse() {
		MatchBonusType result = MatchBonusType.FALSE;
		boolean bonusMatch1 = result.isBonusMatch(false);

		assertThat(bonusMatch1).isTrue();

		boolean bonusMatch2 = result.isBonusMatch(true);

		assertThat(bonusMatch2).isFalse();
	}

	@Test
	@DisplayName("보너스 숫자가 일치여부 상관없이 참이다.")
	public void checkMatchType() {
		MatchBonusType result = MatchBonusType.NONE;
		boolean bonusMatch1 = result.isBonusMatch(false);

		assertThat(bonusMatch1).isTrue();

		boolean bonusMatch2 = result.isBonusMatch(true);

		assertThat(bonusMatch2).isTrue();
	}

}