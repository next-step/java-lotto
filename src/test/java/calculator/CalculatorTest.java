package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {
	Calculator calculator = new Calculator();

	@DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환")
	@ParameterizedTest
	@NullAndEmptySource
	public void test_1(String input) throws Exception {
	    // given
		int expectedResult = 0;
	    // when
		int actualResult = calculator.calculate(input);
	    // then
		assertThat(actualResult).isEqualTo(expectedResult);
	}

	@DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환")
	@ParameterizedTest
	@CsvSource({"1,1", "2,2", "3,3"})
	public void test_2(String input, int expectedResult) throws Exception {
	    // given
	    
	    // when
	    int actualResult = calculator.calculate(input);
	    // then
		assertThat(actualResult).isEqualTo(expectedResult);
	}

	@DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환")
	@ParameterizedTest
	@CsvSource(value = {"1,1^2", "2,2^4", "3,3^6"}, delimiter = '^')
	public void test_3(String input, int expectedResult) throws Exception {
	    // given

	    // when
		int actualResult = calculator.calculate(input);
	    // then
		assertThat(actualResult).isEqualTo(expectedResult);
	}

	@DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용 테스트")
	@ParameterizedTest
	@CsvSource(value = {"1,1:2^4", "2,2:3^7", "4:3,3^10"}, delimiter = '^')
	public void test_4(String input, int expectedResult) throws Exception {
	    // given

	    // when
		int actualResult = calculator.calculate(input);
	    // then
		assertThat(actualResult).isEqualTo(expectedResult);
	}


	@DisplayName("'//'와 '\\n' 문자 사이에 커스텀 구분자를 지정 테스트")
	@Test
	public void test_5() throws Exception {
		// given
		int expectedResult = 6;
		// when
		int actualResult = calculator.calculate("//;\n1;2;3");
		// then
		assertThat(actualResult).isEqualTo(expectedResult);
	}

	@DisplayName("음수 또는 숫자 외의 문자를 전달할 경우 RuntimeException 예외가 발생 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"-1:1,2", "1,-2:3", "4,1:-5", "1,a:3", "b:1:5"})
	public void test_6(String input) throws Exception {
		// given
		// when
		// then
		assertThatThrownBy(() -> calculator.calculate(input)).isInstanceOf(RuntimeException.class);
	}



}