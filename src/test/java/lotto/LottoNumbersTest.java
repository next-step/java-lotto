package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

	@ParameterizedTest
	@ValueSource(ints = {0, 1, 5})
	@DisplayName("로또 번호 유효성검사(실패케이스) - 숫자 갯수 틀림")
	void validateNumbers_sizeWrong(int size) {
		// given
		List<Integer> lottoNumbers = createAscOrderNumberList(size);

		// when & then
		assertThatThrownBy(() -> LottoNumbers.validateNumbers(lottoNumbers))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("size must be");
	}

	private List<Integer> createAscOrderNumberList(int size) {
		List<Integer> numbers = new ArrayList<>();
		for (int number = 1; number < size + 1; number++) {
			numbers.add(number);
		}
		return numbers;
	}

	@ParameterizedTest
	@ValueSource(ints = {-1, 0, 46})
	@DisplayName("로또 번호 유효성검사(실패케이스) - 숫자 범위 틀림")
	void validateNumbers_rangeWrong(int number) {
		// given
		List<Integer> lottoNumbers = Arrays.asList(2, 5, 7, 40, 43, number);

		// when & then
		assertThatThrownBy(() -> LottoNumbers.validateNumbers(lottoNumbers))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("range must in");
	}

	@Test
	@DisplayName("로또 번호 유효성검사(실패케이스) - 겹치는 숫자 존재")
	void validateNumbers_duplicatedNumber() {
		// given
		List<Integer> lottoNumbers1 = Arrays.asList(1, 1, 5, 10, 20, 40);

		// when & then
		assertThatThrownBy(() -> LottoNumbers.validateNumbers(lottoNumbers1))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("duplicated");
	}

	@ParameterizedTest
	@CsvSource(value = {
			"1,5,10,15,20,25|15,20,25,30,35,40|15,20,25",
			"1,2,3,4,5,6|1,8,9,10,11,12|1",
			"1,2,3,4,5,6|1,2,3,4,5,6|1,2,3,4,5,6"}, delimiter = '|')
	@DisplayName("로또 번호 일치하는 숫자들 갖고오는 테스트(일치하는 것이 존재)")
	void getMatchedNumbers_hasLeastOne(String stringNumbers1, String stringNumbers2, String stringExpected) {
		// given
		List<Integer> numbers1 = toIntegerList(stringNumbers1);
		List<Integer> numbers2 = toIntegerList(stringNumbers2);
		LottoNumbers lottoNumbers1 = new LottoNumbers(numbers1);
		LottoNumbers lottoNumbers2 = new LottoNumbers(numbers2);

		// when
		List<Integer> matchedNumbers = lottoNumbers1.getMatchedNumbers(lottoNumbers2);

		// then
		List<Integer> expectedNumbers = toIntegerList(stringExpected);
		assertThat(matchedNumbers).containsExactlyElementsOf(expectedNumbers);
	}

	@ParameterizedTest
	@CsvSource(value = {
			"1,2,3,4,5,6|7,8,9,10,11,12",
			"3,6,9,12,15,18|8,16,24,32,40,45"}, delimiter = '|')
	@DisplayName("로또 번호 일치하는 숫자들 갖고오는 테스트(일치 없음)")
	void getMatchedNumbers_noMatched(String stringNumbers1, String stringNumbers2) {
		// given
		List<Integer> numbers1 = toIntegerList(stringNumbers1);
		List<Integer> numbers2 = toIntegerList(stringNumbers2);
		LottoNumbers lottoNumbers1 = new LottoNumbers(numbers1);
		LottoNumbers lottoNumbers2 = new LottoNumbers(numbers2);

		// when
		List<Integer> matchedNumbers = lottoNumbers1.getMatchedNumbers(lottoNumbers2);

		// then
		assertThat(matchedNumbers).isEmpty();
	}

	private List<Integer> toIntegerList(String numbers) {
		return Arrays.stream(numbers.split(","))
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}
}
