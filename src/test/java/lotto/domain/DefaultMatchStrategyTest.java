package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lotto.utils.LottoNumberUtils;

class DefaultMatchStrategyTest {
	private final DefaultMatchStrategy defaultMatchStrategy = new DefaultMatchStrategy(4);
	private final LottoLottery lottoLottery = new LottoLottery(LottoNumberUtils.mapToListByComma("1,2,3,4,5,6"));

	@Test
	void isMatch_true_test() {
		WinLottoNumbers winLottoNumbers = new WinLottoNumbers(LottoNumberUtils.mapToListByComma("1,2,3,4,7,8"));

		assertThat(defaultMatchStrategy.isMatch(lottoLottery, winLottoNumbers)).isTrue();
	}

	@Test
	void isMatch_false_test() {
		WinLottoNumbers winLottoNumbers = new WinLottoNumbers(LottoNumberUtils.mapToListByComma("1,2,3,4,6,8"));

		assertThat(defaultMatchStrategy.isMatch(lottoLottery, winLottoNumbers)).isFalse();
	}

}
