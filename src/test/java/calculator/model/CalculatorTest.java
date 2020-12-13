package calculator.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

	private Calculator calculator;
	private String commaStr;
	private String colonStr;
	private String mixedStr;

	@BeforeEach
	void init() {

		commaStr = "1,2,3";
		colonStr = "1:2:3";
		mixedStr = "1,2:3";
	}

	@Test
	@DisplayName("문자열 계산기: 나눈 문자열 계산 테스트")
	void calculateTest() {

		calculator = new Calculator(colonStr);
		assertThat(calculator.calculate()).isEqualTo(6);

		calculator = new Calculator(colonStr);
		assertThat(calculator.calculate()).isEqualTo(6);

		calculator = new Calculator(mixedStr);
		assertThat(calculator.calculate()).isEqualTo(6);
	}

	@Test
	@DisplayName("문자열 계산기: 다양한 구분자 계산식 생성 및 문자열 나누기 테스트")
	void splitTest() {

		String[] inputArray = {"1", "2", "3"};
		calculator = new Calculator(commaStr);
		assertThat(calculator.getExpression()).isEqualTo(Arrays.asList(inputArray));

		calculator = new Calculator(colonStr);
		assertThat(calculator.getExpression()).isEqualTo(Arrays.asList(inputArray));

		calculator = new Calculator(mixedStr);
		assertThat(calculator.getExpression()).isEqualTo(Arrays.asList(inputArray));
	}

	@Test
	@DisplayName("문자열 계산기: 계산식을 가지는 객체 생성 테스트")
	void initCalculator() {

		calculator = new Calculator(mixedStr);

		assertThat(calculator).isEqualTo(new Calculator(mixedStr));
	}
}
