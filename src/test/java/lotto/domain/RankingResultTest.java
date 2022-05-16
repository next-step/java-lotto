package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankingResultTest {

	@DisplayName("랭킹결과를 통해 수익률 계산")
	@Test
	public void calculateRoiTest() {
		RankingResult rankingResult = new RankingResult(PurchaseLottoGroupTest.GROUP1,
			WinningNumberTest.WINNING_NUMBER_1);

		assertThat(rankingResult.calculateRoi().crop(2))
			.isEqualTo(1.00);

	}

}