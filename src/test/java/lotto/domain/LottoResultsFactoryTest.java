package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultsFactoryTest {
	@Test
	@DisplayName("당첨된 등수 리스트로 LottoResults를 생성한다.")
	void create_test() {
		List<LottoRank> lottoRanks = Arrays.asList(
			LottoRank.FIRST_PLACE,
			LottoRank.FOURTH_PLACE,
			LottoRank.FOURTH_PLACE,
			LottoRank.THIRD_PLACE
		);

		LottoResults lottoResults = LottoResultsFactory.create(lottoRanks);

		assertThat(lottoResults.findLottoResult(LottoRank.FIRST_PLACE).getWinnerCount())
			.isEqualTo(1);
		assertThat(lottoResults.findLottoResult(LottoRank.FOURTH_PLACE).getWinnerCount())
			.isEqualTo(2);
		assertThat(lottoResults.findLottoResult(LottoRank.THIRD_PLACE).getWinnerCount())
			.isEqualTo(1);
	}
}