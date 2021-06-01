package kht2199.lotto.view;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import kht2199.lotto.exception.input.InvalidInputError;
import kht2199.lotto.exception.input.InvalidInputException;

/**
 *
 * @author heetaek.kim
 */
class InputViewTest {

	@ParameterizedTest
	@DisplayName("당첨번호 입력에 대한 유효성 체크")
	@MethodSource("validationLottoResultStringSource")
	void validationLottoResultString(String input, InvalidInputError error) {
		InputView inputView = new InputView();
		if (error != null) {
			assertThatThrownBy(() -> inputView.validationLottoResultString(input))
				.isInstanceOf(InvalidInputException.class)
				.hasFieldOrPropertyWithValue("error", error)
			;
			return;
		}
		assertDoesNotThrow(() -> inputView.validationLottoResultString(input));
	}

	static Stream<Arguments> validationLottoResultStringSource() {
		return Stream.of(
			Arguments.of("1,2,3,4,5,6", null),
			Arguments.of("", InvalidInputError.EMPTY),
			Arguments.of("1,2,3,4", InvalidInputError.LENGTH),
			Arguments.of("1,2,3,a", InvalidInputError.LENGTH), // 길이가 먼저 체크된다.
			Arguments.of("1,2,3,4,5,a", InvalidInputError.PARSING)
		);
	}
}