package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BonusBallTest {

	@DisplayName("보너스 볼을 입력받아 포함된지 테스트한다.")
	@Test
	void 보너스볼_테스트() {
		LottoWinnerNumbers lottoWinnerNumbers = LottoWinnerNumbers.ofUser("8, 21, 23, 41, 42, 43", "7");

		assertThat(lottoWinnerNumbers.getMatchCount(LottoNumberGenerator.ofInput("8, 21, 23, 41, 42, 43"))).isEqualTo(6);
		assertThat(lottoWinnerNumbers.hasBonusBall(new LottoNumber(7))).isTrue();

	}
}
