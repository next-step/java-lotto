package pluscalculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import pluscalculator.argument.OperatorType;

@DisplayName("입력값에 따른 패턴 테스트")
public class OperatorTypeTest {

	@ParameterizedTest
	@DisplayName("기본 패턴 테스트")
	@MethodSource("basicParameterProvider")
	public void basicPatternTest(String param, OperatorType expect) {
		OperatorType operatorType = OperatorType.getOperatorTypeBy(param);
		assertThat(operatorType).isEqualTo(expect);
	}

	@ParameterizedTest
	@DisplayName("커스텀 패턴 테스트")
	@MethodSource("customParameterProvider")
	public void customPatternTest(String param, OperatorType expect) {
		OperatorType operatorType = OperatorType.getOperatorTypeBy(param);
		assertThat(operatorType).isEqualTo(expect);
	}

	@ParameterizedTest
	@DisplayName("수가 하나만 있는 경우 테스트")
	@MethodSource("onlyOneNumberParameterProvider")
	public void onlyOneNumberPatternTest(String param, OperatorType expect) {
		OperatorType operatorType = OperatorType.getOperatorTypeBy(param);
		assertThat(operatorType).isEqualTo(expect);
	}

	private static Stream<Arguments> basicParameterProvider() {
		return Stream.of(
				Arguments.arguments("1:2", OperatorType.DEFAULT),
				Arguments.arguments("1:2:4", OperatorType.DEFAULT),
				Arguments.arguments("11:22:1:100", OperatorType.DEFAULT),
				Arguments.arguments("1,2,3", OperatorType.DEFAULT),
				Arguments.arguments("1,2:3", OperatorType.DEFAULT)
						);
	}

	private static Stream<Arguments> customParameterProvider() {
		return Stream.of(
				Arguments.arguments("//;\\n1;2;3", OperatorType.CUSTOM),
				Arguments.arguments("//%\\n1%2%3", OperatorType.CUSTOM),
				Arguments.arguments("//;\\n11;200;3;45", OperatorType.CUSTOM)
						);
	}

	private static Stream<Arguments> onlyOneNumberParameterProvider() {
		return Stream.of(
				Arguments.arguments("1", OperatorType.ONLY_ONE_NUMBER),
				Arguments.arguments("200", OperatorType.ONLY_ONE_NUMBER),
				Arguments.arguments("5342789", OperatorType.ONLY_ONE_NUMBER),
				Arguments.arguments("3", OperatorType.ONLY_ONE_NUMBER)
						);
	}

}
