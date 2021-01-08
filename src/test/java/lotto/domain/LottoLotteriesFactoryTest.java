package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.utils.LottoNumberUtils;

class LottoLotteriesFactoryTest {
	@Test
	@DisplayName("수동 생성된 로또와 자동 생성된 로또로 LottoLotteries를 생성한다.")
	void createLottoLotteries_test() {
		List<LottoLottery> manualLottoLotteries = Arrays.asList(
			new LottoLottery(LottoNumberUtils.mapToListByComma("1,2,3,4,5,6")),
			new LottoLottery(LottoNumberUtils.mapToListByComma("11,12,13,14,15,16")),
			new LottoLottery(LottoNumberUtils.mapToListByComma("21,22,23,24,25,26"))
		);

		List<LottoLottery> autoLottoLotteries = Arrays.asList(
			new LottoLottery(LottoNumberUtils.mapToListByComma("1,2,3,4,5,6")),
			new LottoLottery(LottoNumberUtils.mapToListByComma("11,12,13,14,15,16"))
		);

		LottoLotteries lottoLotteries = LottoLotteriesFactory.createLottoLotteries(manualLottoLotteries,
			autoLottoLotteries);

		assertThat(lottoLotteries.getCount())
			.isEqualTo(5);
	}
}