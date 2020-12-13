package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BonusBallTest {

	@DisplayName("보너스 볼을 입력받아 포함된지 테스트한다.")
	@Test
	void 보너스볼_테스트() {
		LottoWinnerNumbers lottoWinnerNumbers = LottoWinnerNumbers.ofUser("8, 21, 23, 41, 42, 43", "7");
		LottoNumbers containBonus = LottoNumberGenerator.ofInput("8, 21, 23, 41, 42, 7");
		LottoNumbers notContainBonus = LottoNumberGenerator.ofInput("8, 21, 23, 41, 42, 1");

		assertThat(lottoWinnerNumbers.hasBonusBall(containBonus)).isTrue();

		assertThat(LottoResult.matchesRank(containBonus, lottoWinnerNumbers)).isEqualTo(Rank.SECOND);
		assertThat(LottoResult.matchesRank(notContainBonus, lottoWinnerNumbers)).isEqualTo(Rank.THIRD);

	}

	@DisplayName("2등 판단 테스트")
	@Test
	void 보너스_등수_테스트() throws Exception {
		assertThat(Rank.ofMatchesCount(3, true)).isEqualTo(Rank.FIFTH);
		assertThat(Rank.ofMatchesCount(5, true)).isEqualTo(Rank.SECOND);
		assertThat(Rank.ofMatchesCount(5, false)).isEqualTo(Rank.THIRD);
	}
}
