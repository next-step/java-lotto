package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.utils.LottoNumberUtils;

class LottoRankTest {
	@Test
	@DisplayName("복권이 당첨된 등수를 리턴한다.")
	void findMatchRank_test() {
		LottoLottery lottoLottery = new LottoLottery(LottoNumberUtils.mapToListByComma("1,2,3,4,5,6"));
		WinLottoNumbers winLottoNumbers = new WinLottoNumbers(LottoNumberUtils.mapToListByComma("1,2,3,11,12,13"),
			new LottoNumber(6));

		assertThat(LottoRank.findMatchRank(lottoLottery, winLottoNumbers))
			.isEqualTo(LottoRank.FIFTH_PLACE);
	}

	@Test
	@DisplayName("당첨 갯수에 따라 총 상금을 계산한다.")
	void getTotalPrize_test() {
		assertThat(LottoRank.FIFTH_PLACE.getTotalPrize(2))
			.isEqualTo(10000);
	}

	@Test
	@DisplayName("2등을 리턴한다.")
	void findMatchRank_second_place_test() {
		LottoLottery lottoLottery = new LottoLottery(LottoNumberUtils.mapToListByComma("1,2,3,4,5,6"));
		WinLottoNumbers winLottoNumbers = new WinLottoNumbers(LottoNumberUtils.mapToListByComma("1,2,3,4,5,10"),
			new LottoNumber(6));

		assertThat(LottoRank.findMatchRank(lottoLottery, winLottoNumbers))
			.isEqualTo(LottoRank.SECOND_PLACE);
	}
}