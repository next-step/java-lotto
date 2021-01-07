package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.utils.LottoNumberUtils;

class WinLottoNumbersTest {
	private WinLottoNumbers winLottoNumbers;

	@BeforeEach
	void setUp() {
		winLottoNumbers = new WinLottoNumbers(LottoNumberUtils.mapToListByComma("1,2,3,4,5,6"), LottoNumber.of(7));
	}

	@Test
	@DisplayName("당첨 숫자의 갯수가 입력된 숫자와 같은지 확인한다.")
	void isEqualMatchCount_test() {
		LottoLottery lottoLottery = new LottoLottery(LottoNumberUtils.mapToListByComma("1,2,3,11,12,13"));

		assertAll(
			() -> assertThat(winLottoNumbers.isEqualMatchCount(lottoLottery, 3)).isTrue(),
			() -> assertThat(winLottoNumbers.isEqualMatchCount(lottoLottery, 2)).isFalse(),
			() -> assertThat(winLottoNumbers.isEqualMatchCount(lottoLottery, 4)).isFalse()
		);
	}

	@Test
	@DisplayName("보너스 볼 숫자가 맞는지 확인하다.")
	void isMatchBonusBallNumber_test() {
		LottoLottery trueLottoLottery = new LottoLottery(LottoNumberUtils.mapToListByComma("1,2,3,4,5,7"));
		LottoLottery falseLottoLottery = new LottoLottery(LottoNumberUtils.mapToListByComma("1,2,3,4,5,6"));

		assertAll(
			() -> assertThat(winLottoNumbers.isMatchBonusBallNumber(trueLottoLottery)).isTrue(),
			() -> assertThat(winLottoNumbers.isMatchBonusBallNumber(falseLottoLottery)).isFalse()
		);
	}
}