package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class LottoNumbersTest {

	@DisplayName("6개의 1 ~ 45 숫자가 정상적으로 생성되는지 확인한다.")
	@Test
	void createTest() {
		List<Integer> source = Arrays.asList(1, 5, 9, 3, 19, 30);

		LottoNumbers lottoNumbers = LottoNumbers.of(source);

		assertThat(lottoNumbers.isSameNumbers(source)).isTrue();
	}

	@DisplayName("빈 숫자로 생성시 예외처리 되는지 확인한다.")
	@ParameterizedTest
	@NullAndEmptySource
	void emptyTest(List<Integer> source) {
		assertThatThrownBy(() -> LottoNumbers.of(source))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("6개가 초과 또는 미만되는 숫자로 생성시 예외처리 되는지 확인한다.")
	@ParameterizedTest
	@MethodSource("provideIntegers")
	void sizeValidationTest(List<Integer> source) {
		assertThatThrownBy(() -> LottoNumbers.of(source))
			.isInstanceOf(IllegalArgumentException.class);
	}

	private static Stream<Arguments> provideIntegers() {
		return Stream.of(
			Arguments.of(Arrays.asList(1, 2, 3)),
			Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
		);
	}

	@DisplayName("중복되는 숫자로 생성시 예외처리 되는지 확인한다.")
	@Test
	void duplicateValidationTest() {
		List<Integer> source = Arrays.asList(1, 5, 9, 3, 3, 30);

		assertThatThrownBy(() -> LottoNumbers.of(source))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
