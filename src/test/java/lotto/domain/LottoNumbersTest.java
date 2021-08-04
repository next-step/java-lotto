package lotto.domain;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.exception.InvalidLottoNumberSizeException;

class LottoNumbersTest {

	@DisplayName("지난 주 당첨 번호 문자열로 새로운 객체를 생성한다.")
	@Test
	void create() {
		List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		assertThat(LottoNumbers.from(winningNumbers)).isEqualTo(LottoNumbers.from(winningNumbers));
	}

	@DisplayName("지난 주 당첨 번호가 중복되거나, 6개보다 적거나 많으면 InvalidLottoNumberSizeException 예외가 발생한다.")
	@ValueSource(strings = {"1,2,3,4,5,5", "1,2,3,4,5", "1,2,3,4,5,6,7"})
	@ParameterizedTest
	void duplicateWinningNumbers(String winningNumbers) {
		List<Integer> numbers = Arrays.stream(winningNumbers.split(","))
									.map(Integer::parseInt)
									.collect(toList());

		assertThatThrownBy(() -> LottoNumbers.from(numbers))
			.isInstanceOf(InvalidLottoNumberSizeException.class);
	}

}