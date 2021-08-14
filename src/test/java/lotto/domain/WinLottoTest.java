package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinLottoTest {

	private WinLotto winLotto;

	@BeforeEach
	void init() {
		winLotto = WinLotto.of("1, 2, 3, 4, 5, 6", 7);
	}

	@ParameterizedTest
	@CsvSource(value = {"1=true", "2=true", "3=true", "4=true", "5=true", "6=true", "7=false"}, delimiter = '=')
	@DisplayName("우승 번호에 로또 번호가 포함되어 있는지 확인")
	void compareLottoNumberTest(int input, boolean expected) {
		assertThat(winLotto.containsLottoNumber(LottoNumber.valueOf(input))).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"1=false", "2=false", "3=false", "4=false", "5=false", "6=false", "7=true"}, delimiter = '=')
	@DisplayName("보너스 번호가 포함되어 있는지 확인")
	void compareBonuseLottoNumberTest(int input, boolean expected) {
		assertThat(winLotto.getBonusNumber() == LottoNumber.valueOf(input)).isEqualTo(expected);
	}
}