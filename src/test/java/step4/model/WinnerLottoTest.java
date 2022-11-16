package step4.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class WinnerLottoTest {

	public static Stream<Arguments> checkWinningNumberArguments() {
		return Stream.of(
				Arguments.arguments("1, 1, 2, 3, 4, 5", 6),
				Arguments.arguments("100, 45, 1, 2, 3, 4", 5)
		);
	}

	@ParameterizedTest
	@MethodSource("checkWinningNumberArguments")
	void checkWinningNumber(String winningNumber, int bonusNumber){
		Assertions.assertThatThrownBy(() -> new step3.model.WinnerLotto(winningNumber, bonusNumber)).isInstanceOf(IllegalArgumentException.class);
	}

	static Stream<Arguments> checkBonusNumberStatus(){
		return Stream.of(
				Arguments.arguments("1,2,3,4,5,6", 1),
				Arguments.arguments("1,2,3,4,5,6", 56)
		);
	}

	@ParameterizedTest
	@MethodSource("checkBonusNumberStatus")
	void checkBonusNumber(String winningNumber, int bonusNumber){
		Assertions.assertThatThrownBy(() -> new WinnerLotto(winningNumber, bonusNumber)).isInstanceOf(IllegalArgumentException.class);
	}
}