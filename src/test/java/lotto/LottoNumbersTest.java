package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.domain.LottoNumbers;
import lotto.exception.ErrorMessage;
import lotto.exception.InvalidLottoNumberQuantityException;

class LottoNumbersTest {

	public static Stream<Arguments> providerOfSixNumbers() {
		return Stream.of(
			Arguments.arguments(List.of(1, 2, 3, 4, 5, 6)),
			Arguments.arguments(List.of(10, 15, 20, 25, 30, 35))
		);
	}

	public static Stream<Arguments> providerOfNumbersOtherThanSix() {
		return Stream.of(
			Arguments.arguments(List.of(1, 2, 3, 4, 5)),
			Arguments.arguments(List.of(10, 15, 20, 25, 30, 35, 40)),
			Arguments.arguments(List.of(1))
		);
	}

	@DisplayName("숫자 6개가 주어지면 정상적으로 객체가 생성된다.")
	@ParameterizedTest
	@MethodSource("providerOfSixNumbers")
	void Should_Create_Object_When_Provide_Six_Numbers(
		List<Integer> numbers
	) {
		assertThatNoException().isThrownBy(
			() -> {
				LottoNumbers lottoNumbers = LottoNumbers.of(numbers);
			}
		);
	}

	@DisplayName("숫자가 6개가 아니면 예외를 던진다.")
	@ParameterizedTest
	@MethodSource("providerOfNumbersOtherThanSix")
	void Should_Throw_Exception_Given_Numbers_Other_Than_Six(
		List<Integer> numbers
	) {
		assertThatThrownBy(
			() -> {
				LottoNumbers lottoNumbers = LottoNumbers.of(numbers);
			}
		).isInstanceOf(InvalidLottoNumberQuantityException.class)
			.hasMessage(ErrorMessage.LOTTO_NUMBERS_QUANTITY_MUST_BE_SIX.getMessage());
	}
}
