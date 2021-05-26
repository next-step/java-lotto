package lotto;

import static lotto.Rank.*;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WinningResultTest {

	Lottos lottos;

	@BeforeEach
	void setUp() {
		Lotto lotto1 = new Lotto("1,2,3,4,5,6");
		Lotto lotto2 = new Lotto("7,8,9,10,11,12");
		Lotto lotto3 = new Lotto("40,41,42,43,44,45");
		Lotto lotto4 = new Lotto("40,41,42,43,44,45");
		Lotto lotto5 = new Lotto("40,41,42,43,44,45");
		lottos = new Lottos(new ArrayList<>(Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5)));
	}

	@ParameterizedTest
	@CsvSource(value = {
		"1,2,3,4,5,6		:7		:0:0:0:0:1",
		"2,3,4,5,6,7		:1		:0:0:0:1:0",
		"2,3,4,5,6,7		:45		:0:0:1:0:0",
		"4,5,6,7,8,9		:45		:2:0:0:0:0",
		"40,41,42,43,44,45	:1		:0:0:0:0:3"
	}, delimiter = ':')
	@DisplayName("당첨 결과 확인")
	void 당첨_결과_확인(String lottoNumbers, int bonusNumber,
			int fifth, int fourth, int third, int second, int first) {
		Lotto winLotto = new Lotto(lottoNumbers);
		LottoNumber bonusBall = LottoNumber.valueOf(bonusNumber);
		WinningNumber winningNumber = new WinningNumber(winLotto, bonusBall);

		WinningResult result = new WinningResult(winningNumber, lottos);
		assertThat(result.dashboard().get(FIFTH_PRIZE)).isEqualTo(fifth);
		assertThat(result.dashboard().get(FOURTH_PRIZE)).isEqualTo(fourth);
		assertThat(result.dashboard().get(THIRD_PRIZE)).isEqualTo(third);
		assertThat(result.dashboard().get(SECOND_PRIZE)).isEqualTo(second);
		assertThat(result.dashboard().get(FIRST_PRIZE)).isEqualTo(first);
	}

	@ParameterizedTest
	@CsvSource(value = {
		"1,2,3,4,5,6		:7		:400000.00",
		"2,3,4,5,6,7		:1		:6000.00",
		"2,3,4,5,6,7		:45		:300.00",
		"4,5,6,7,8,9		:45		:2",
		"40,41,42,43,44,45	:1		:1200000.00"
	}, delimiter = ':')
	@DisplayName("당첨 수익률 확인")
	void 당첨_수익률_확인(String lottoNumbers, int bonusNumber, double expectedRatio) {
		Lotto winLotto = new Lotto(lottoNumbers);
		LottoNumber bonusBall = LottoNumber.valueOf(bonusNumber);
		WinningNumber winningNumber = new WinningNumber(winLotto, bonusBall);
		WinningResult result = new WinningResult(winningNumber, lottos);
		assertThat(result.earningRate()).isEqualTo(expectedRatio);
	}
}
