package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import exception.StringParsingToNumberException;

public class WinningNumbersTest {
	public static List<LottoNumber> NUMBERS_1 = List.of(
		LottoNumber.from(1),
		LottoNumber.from(2),
		LottoNumber.from(3),
		LottoNumber.from(4),
		LottoNumber.from(5),
		LottoNumber.from(6)
	);

	public static LottoNumber BONUS_1 = LottoNumber.from(8);
	public static LottoNumber BONUS_2 = LottoNumber.from(9);

	@DisplayName("입력한 당첨번호가 6개가 아닌경우 에러 발생")
	@CsvSource(value = {"1,2,3,4,5,6,7:9", "1,2,3,4,5:9", "1,2,3,4,5,5:9"}, delimiter = ':')
	@ParameterizedTest
	public void When_GivenWrongSizeInput_Expected_IllegalArgumentException(String winningNumberInput, String bonusNumberInput) {
		assertThatThrownBy(() -> new WinningNumbers(
			splitWinningNumbersInput(winningNumberInput),
			LottoNumber.from(bonusNumberInput)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("입력한 당첨번호들 중 숫자가 아닌 경우 에러 발생")
	@CsvSource(value = {"1,2,3,4,5,!6:7", "1,2,a3,4,5,6:7"}, delimiter = ':')
	@ParameterizedTest
	public void When_GivenWrongNumberInput_Expected_StringParsingToIntegerException(String winningNumberInput, String bonusNumberInput) {
		assertThatThrownBy(() -> new WinningNumbers(
			splitWinningNumbersInput(winningNumberInput),
			LottoNumber.from(bonusNumberInput)))
			.isInstanceOf(StringParsingToNumberException.class);
	}

	@DisplayName("로또와 당첨번호간 일치 갯수")
	@CsvSource(value = {"7,5,4,3,2,1:5", "8,45,4,3,2,1:4"}, delimiter = ':')
	@ParameterizedTest
	public void When_GivenWinningAndLotto_Expected_SameCount(String lottoInput, long quantity) {
		WinningNumbers winningNumbers = new WinningNumbers(NUMBERS_1, BONUS_1);
		Lotto lotto = new Lotto(lottoInput);

		assertThat(winningNumbers.matchQuantity(lotto)).isEqualTo(quantity);
	}

	@DisplayName("로또와 보너스번호 포함 여부")
	@CsvSource(value = {"7,5,4,3,2,1:false", "8,5,4,3,2,1:true"}, delimiter = ':')
	@ParameterizedTest
	public void When_GivenWinningAndLotto_Expected_MatchingBonus(String lottoInput, boolean expected) {
		WinningNumbers winningNumbers = new WinningNumbers(NUMBERS_1, BONUS_2);
		Lotto lotto = new Lotto(lottoInput);

		assertThat(winningNumbers.matchBonus(lotto)).isEqualTo(expected);
	}

	private List<LottoNumber> splitWinningNumbersInput(String winningNumberInput) {
		return Stream.of(winningNumberInput.split(WinningNumbers.DELIMITER))
			.map(LottoNumber::from)
			.collect(Collectors.toList());
	}
}
