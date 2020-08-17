package pluscalculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import pluscalculator.argument.CalculatorArguments;
import pluscalculator.argument.Operands;
import pluscalculator.argument.Operator;

public class CalculatorArgumentsTest {

	@DisplayName("사용자의 입력을 CalculatorArguments로 변경하는 테스트")
	@ParameterizedTest
	@MethodSource("inputParameterProvider")
	public void inputToArgumentsTest(String inputOfUser, CalculatorArguments expect) {
		CalculatorArguments actual = CalculatorArguments.from(inputOfUser);
		assertThat(actual).isEqualTo(expect);
	}

	private static Stream<Arguments> inputParameterProvider() {
		return Stream.of(
				Arguments.arguments("10:20", CalculatorArguments.of(Operands.from(new String[]{"10", "20"}),
																	Operator.PLUS)),
				Arguments.arguments("23:42:617", CalculatorArguments.of(Operands.from(new String[]{"23", "42", "617"}),
																		Operator.PLUS)),
				Arguments.arguments("11:22:1:100", CalculatorArguments.of(Operands.from(new String[]{"11", "22", "1", "100"}),
																		  Operator.PLUS)),
				Arguments.arguments("5748,3784,132", CalculatorArguments.of(Operands.from(new String[]{"5748", "3784", "132"}),
																			Operator.PLUS)),
				Arguments.arguments("1,2:3", CalculatorArguments.of(Operands.from(new String[]{"1", "2", "3"}),
																	Operator.PLUS))
						);
	}
}
