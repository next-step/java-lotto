package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.utils.LottoNumberUtils;

public class LottoLotteriesTest {
	@Test
	@DisplayName("생성된 로또의 갯수를 반환한다.")
	void getCount_test() {
		LottoLotteries lottoLotteries = new LottoLotteries(
			Arrays.asList(
				new LottoLottery(LottoNumberUtils.mapToListByComma("1,2,3,4,5,6")),
				new LottoLottery(LottoNumberUtils.mapToListByComma("11,12,13,14,15,16")),
				new LottoLottery(LottoNumberUtils.mapToListByComma("21,22,23,24,25,26"))
			)
		);

		assertThat(lottoLotteries.getCount()).isEqualTo(3);
	}

	@Test
	@DisplayName("생성된 로또들의 당첨을 확인한다.")
	void checkLottoRanks_test() {
		LottoLotteries lottoLotteries = new LottoLotteries(
			Arrays.asList(
				new LottoLottery(LottoNumberUtils.mapToListByComma("1,2,3,4,5,6")),
				new LottoLottery(LottoNumberUtils.mapToListByComma("1,2,3,11,12,13")),
				new LottoLottery(LottoNumberUtils.mapToListByComma("21,22,23,24,25,26"))
			)
		);
		WinLottoNumbers winLottoNumbers = new WinLottoNumbers(LottoNumberUtils.mapToListByComma("1,2,3,4,31,32"),
			LottoNumber.of(6));

		assertThat(lottoLotteries.checkLottoRanks(winLottoNumbers))
			.hasSize(3)
			.containsExactly(
				LottoRank.FOURTH_PLACE,
				LottoRank.FIFTH_PLACE,
				LottoRank.NONE
			);
	}
}
