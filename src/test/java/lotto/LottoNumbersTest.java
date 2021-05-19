package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumbersTest {

	@Test
	@DisplayName("LottoNumbers 는 LottoNumber 6개로 구성된다.")
	public void createLottoNumbersTest() {
		LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));

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

	@Test
	@DisplayName("LottoNumbers 는 오름차순으로 정렬되어서 저장이 된다.")
	public void sortLottoNumbersTest() {
		LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(4, 5, 1, 2, 3, 6));

		assertThat(lottoNumbers.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
	}

	private List<Integer> splitAndMapToInt(String input) {
		String[] split = input.split(",");
		return Stream.of(split)
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}
}
