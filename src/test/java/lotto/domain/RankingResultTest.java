package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankingResultTest {

	@DisplayName("랭킹결과를 통해 수익률 계산")
	@Test
	public void calculateRoiTest() {
		RankingResult rankingResult = new RankingResult(List.of(
			LottoRank.FIFTH,
			LottoRank.NOTHING,
			LottoRank.NOTHING,
			LottoRank.NOTHING,
			LottoRank.NOTHING
		));

		assertThat(rankingResult.calculateRoi().crop(2))
			.isEqualTo(1.00);

	}

}