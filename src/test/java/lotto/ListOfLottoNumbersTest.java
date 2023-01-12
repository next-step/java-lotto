package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.domain.ListOfLottoNumbers;

class ListOfLottoNumbersTest {

	public static Stream<Arguments> providerOfListOfSixNumbers() {
		return Stream.of(
			Arguments.arguments(List.of(List.of(1, 2, 3, 4, 5, 6), List.of(10, 15, 20, 25, 30, 35))),
			Arguments.arguments(List.of(List.of(11, 12, 13, 14, 15, 16), List.of(11, 16, 21, 26, 31, 36)))
		);
	}

	@DisplayName("숫자 6개가 주어지면 정상적으로 객체가 생성된다.")
	@ParameterizedTest
	@MethodSource("providerOfListOfSixNumbers")
	void Should_Create_Object_When_Provide_Six_Numbers(
		List<List<Integer>> listOfNumbers
	) {
		assertThatNoException().isThrownBy(
			() -> {
				ListOfLottoNumbers listOfLottoNumbers = ListOfLottoNumbers.of(listOfNumbers);
			}
		);
	}
}
