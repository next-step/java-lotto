package pluscalculator;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import pluscalculator.argument.CalculatorArguments;
import pluscalculator.calculator.StringCalculator;
import pluscalculator.result.CalculatorResult;

@DisplayName("계산 테스트")
public class CalculatorTest {

	@ParameterizedTest
	@DisplayName("기본 패턴 테스트")
	@MethodSource("basicParameterProvider")
	public void basicPatternTest(String param, String expect) {
		CalculatorResult result = StringCalculator.calculate(CalculatorArguments.from(param));
		assertThat(result.viewResult()).isEqualTo(expect);
	}

	@ParameterizedTest
	@DisplayName("커스텀 패턴 테스트")
	@MethodSource("customParameterProvider")
	public void customPatternTest(String param, String expect) {
		CalculatorResult result = StringCalculator.calculate(CalculatorArguments.from(param));
		assertThat(result.viewResult()).isEqualTo(expect);
	}

	@ParameterizedTest
	@DisplayName("그 외 경우 테스트")
	@MethodSource("etcParameterProvider")
	public void etcPatternTest(String param, String expect) {
		CalculatorResult result = StringCalculator.calculate(CalculatorArguments.from(param));
		assertThat(result.viewResult()).isEqualTo(expect);
	}

	private static Stream<Arguments> basicParameterProvider() {
		return Stream.of(
				Arguments.arguments("10:2", "12"),
				Arguments.arguments("46:10:44", "100"),
				Arguments.arguments("43:23:10:8", "84"),
				Arguments.arguments("13,55,789", "857"),
				Arguments.arguments("10,39:1", "50")
						);
	}

	private static Stream<Arguments> customParameterProvider() {
		return Stream.of(
				Arguments.arguments("//;\\n4;5;1", "10"),
				Arguments.arguments("//%\\n20%43%11", "74"),
				Arguments.arguments("//;\\n47;46;1;23", "117")
						);
	}

	private static Stream<Arguments> etcParameterProvider() {
		return Stream.of(
				Arguments.arguments(null, "0"),
				Arguments.arguments("", "0"),
				Arguments.arguments(" ", "0"),
				Arguments.arguments("3", "3")
						);
	}
}
