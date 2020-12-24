package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultsTest {
	private LottoResults lottoResults;

	@BeforeEach
	void setUp() {
		List<LottoRank> lottoRanks = Arrays.asList(
			LottoRank.FOURTH_PLACE,
			LottoRank.THIRD_PLACE,
			LottoRank.THIRD_PLACE,
			LottoRank.NONE,
			LottoRank.NONE
		);

		lottoResults = LottoResultsFactory.create(lottoRanks);
	}

	@Test
	@DisplayName("LottoRank로 LottoResult를 찾아낸다.")
	void findLottoResult_test() {
		LottoResult lottoResult = lottoResults.findLottoResult(LottoRank.THIRD_PLACE);
		assertThat(lottoResult.getLottoRank())
			.isEqualTo(LottoRank.THIRD_PLACE);
		assertThat(lottoResult.getWinnerCount())
			.isEqualTo(2);
	}

	@Test
	@DisplayName("복권으로 인한 수익률을 계산한다.")
	void calculateReturnRate_test() {
		assertThat(lottoResults.calculateReturnRate()).isEqualTo(21);
	}
}