package pluscalculator;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import pluscalculator.calculator.StringCalculator;
import pluscalculator.result.CalculatorResult;
import pluscalculator.util.InputAnalyzer;

@DisplayName("계산 테스트")
public class CalculatorTest {

	@ParameterizedTest
	@DisplayName("기본 패턴 테스트")
	@MethodSource("basicParameterProvider")
	public void basicPatternTest(String param, String expect) {
		CalculatorResult result = StringCalculator.calculate(InputAnalyzer.analyze(param));
		assertThat(result.viewResult()).isEqualTo(expect);
	}

	@ParameterizedTest
	@DisplayName("커스텀 패턴 테스트")
	@MethodSource("customParameterProvider")
	public void customPatternTest(String param, String expect) {
		CalculatorResult result = StringCalculator.calculate(InputAnalyzer.analyze(param));
		assertThat(result.viewResult()).isEqualTo(expect);
	}

	@ParameterizedTest
	@DisplayName("그 외 경우 테스트")
	@MethodSource("etcParameterProvider")
	public void etcPatternTest(String param, String expect) {
		CalculatorResult result = StringCalculator.calculate(InputAnalyzer.analyze(param));
		assertThat(result.viewResult()).isEqualTo(expect);
	}

	private static Stream<Arguments> basicParameterProvider() {
		return Stream.of(
				Arguments.arguments("1:2", "3"),
				Arguments.arguments("1:2:4", "7"),
				Arguments.arguments("11:22:1:100", "134"),
				Arguments.arguments("1,2,3", "6"),
				Arguments.arguments("1,2:3", "6")
						);
	}

	private static Stream<Arguments> customParameterProvider() {
		return Stream.of(
				Arguments.arguments("//;\\n1;2;3", "6"),
				Arguments.arguments("//%\\n1%2%3", "6"),
				Arguments.arguments("//;\\n11;200;3;45", "259")
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
