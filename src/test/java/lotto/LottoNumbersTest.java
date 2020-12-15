package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
}
