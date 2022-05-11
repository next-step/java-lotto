package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import exception.StringParsingToNumberException;

public class WinningNumberTest {

	@DisplayName("입력한 당첨번호가 6개가 아닌경우 에러 발생")
	@ValueSource(strings = {"1,2,3,4,5,6,7", "1,2,3,4,5"})
	@ParameterizedTest
	public void When_GivenWrongSizeInput_Expected_IllegalArgumentException(String input) {
		assertThatThrownBy(() -> new WinningNumber(input))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("입력한 당첨번호들 중 숫자가 아닌 경우 에러 발생")
	@ValueSource(strings = {"1,2,3,4,5,!6", "1,2,a3,4,5,6"})
	@ParameterizedTest
	public void When_GivenWrongNumberInput_Expected_StringParsingToIntegerException(String input) {
		assertThatThrownBy(() -> new WinningNumber(input))
			.isInstanceOf(StringParsingToNumberException.class);
	}

	@DisplayName("당첨번호와 로또간 일치 갯수")
	@CsvSource(value = {"1,2,3,4,5,6:6,5,4,3,2,1:6", "1,2,3,4,5,6:1,2,7,8,13,42:2"}, delimiter = ':')
	@ParameterizedTest
	public void When_GivenWinningAndLotto_Expected_SameCount(String winningNumberInput, String lottoInput, long quantity) {
		WinningNumber winningNumber = new WinningNumber(winningNumberInput);
		Lotto lotto = new Lotto(lottoInput);

		assertThat(winningNumber.matchQuantity(lotto)).isEqualTo(quantity);
	}
}
