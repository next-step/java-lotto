package lotto.number;

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
	void constructor_validate_sizeWrong(int size) {
		// given
		List<LottoNumber> lottoNumbers = createAscOrderNumberList(size);

		// when & then
		assertThatThrownBy(() -> new LottoNumbers(lottoNumbers))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("size must be");
	}

	private List<LottoNumber> createAscOrderNumberList(int size) {
		List<LottoNumber> numbers = new ArrayList<>();
		for (int number = 1; number < size + 1; number++) {
			numbers.add(new LottoNumber(number));
		}
		return numbers;
	}

	@Test
	@DisplayName("로또 번호 유효성검사(실패케이스) - 겹치는 숫자 존재")
	void constructor_validate_duplicatedNumber() {
		// given
		List<LottoNumber> lottoNumbers = Arrays.asList(
				new LottoNumber(1),
				new LottoNumber(1),
				new LottoNumber(5),
				new LottoNumber(20),
				new LottoNumber(40),
				new LottoNumber(41));

		// when & then
		assertThatThrownBy(() -> new LottoNumbers(lottoNumbers))
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
		List<LottoNumber> numbers1 = toLottoNumberList(stringNumbers1);
		List<LottoNumber> numbers2 = toLottoNumberList(stringNumbers2);
		LottoNumbers lottoNumbers1 = new LottoNumbers(numbers1);
		LottoNumbers lottoNumbers2 = new LottoNumbers(numbers2);

		// when
		List<LottoNumber> matchedNumbers = lottoNumbers1.getMatchedLottoNumbers(lottoNumbers2);

		// then
		List<LottoNumber> expectedNumbers = toLottoNumberList(stringExpected);
		assertThat(matchedNumbers).containsExactlyElementsOf(expectedNumbers);
	}

	@ParameterizedTest
	@CsvSource(value = {
			"1,2,3,4,5,6|7,8,9,10,11,12",
			"3,6,9,12,15,18|8,16,24,32,40,45"}, delimiter = '|')
	@DisplayName("로또 번호 일치하는 숫자들 갖고오는 테스트(일치 없음)")
	void getMatchedNumbers_noMatched(String stringNumbers1, String stringNumbers2) {
		// given
		List<LottoNumber> numbers1 = toLottoNumberList(stringNumbers1);
		List<LottoNumber> numbers2 = toLottoNumberList(stringNumbers2);
		LottoNumbers lottoNumbers1 = new LottoNumbers(numbers1);
		LottoNumbers lottoNumbers2 = new LottoNumbers(numbers2);

		// when
		List<LottoNumber> matchedNumbers = lottoNumbers1.getMatchedLottoNumbers(lottoNumbers2);

		// then
		assertThat(matchedNumbers).isEmpty();
	}

	private List<LottoNumber> toLottoNumberList(String numbers) {
		return Arrays.stream(numbers.split(","))
				.map(Integer::parseInt)
				.map(LottoNumber::new)
				.collect(Collectors.toList());
	}
}
