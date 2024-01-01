package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public final class MatchingNumbersTest {
	@DisplayName("매칭되는 숫자들이 5개가 맞는지 보너스가 일치하는지 확인")
	@Test
	void 매칭되는_숫자들이_5개가_맞는지_보너스가_일치하는지_확인() {
		MatchingNumbers matchingNumbers = new MatchingNumbers(5, true);

		assertThat(matchingNumbers.isMatching(5) && matchingNumbers.isBonus()).isTrue();
	}
}
