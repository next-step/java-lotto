package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumbersTest {

	private LottoNumbers lottoNumbers;

	@BeforeEach
	public void setup() {
		lottoNumbers = LottoNumbers.of(1, 2, 3, 4, 5, 6);
	}

	@Test
	@DisplayName("LottoNumbers 는 LottoNumber 6개로 구성된다.")
	public void createLottoNumbersTest() {
		assertThat(lottoNumbers.getNumbers()).contains(1, 2, 3, 4, 5, 6);
	}

	@ParameterizedTest
	@DisplayName("LottoNumbers 가 서로 다른 6자리 숫자로 이루어지지 않으면 IllegalArgumentException 가 발생한다")
	@ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7", "1,1,2,3,4,5", "1,1,2,3,4,5,7"})
	public void validationLottoNumbersTest(String notValidInput) {
		List<Integer> numbers = splitAndMapToInt(notValidInput);
		assertThatThrownBy(() -> new LottoNumbers(numbers))
			.isInstanceOf(IllegalArgumentException.class);
	}

	private List<Integer> splitAndMapToInt(String input) {
		String[] split = input.split(",");
		return Stream.of(split)
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}

	@ParameterizedTest
	@DisplayName("LottoNumbers 는 당첨번호와 비교해서 일치하는 개수를 반환한다.")
	@CsvSource(value = {"1,2,3,4,5,6:6", "10,30,20,35,9,19:0", "2,3,1,7,9,8:3"}, delimiter = ':')
	public void matchTest(String inputWinningNumbers, int expectedMatchCount) {
		LottoNumbers winningNumbers = new LottoNumbers(splitAndMapToInt(inputWinningNumbers));

		int matchCount = lottoNumbers.countOfMatch(winningNumbers);

		assertThat(matchCount).isEqualTo(expectedMatchCount);
	}
}
