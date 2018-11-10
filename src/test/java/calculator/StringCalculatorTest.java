package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 * 1. 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
 * 2. 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
 * 3. 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
 */
public class StringCalculatorTest {

	@Test
	public void 숫자_하나() {
		String number = "1";
		int result = StringCalculator.add(number);

		assertThat(result).isEqualTo(1);
	}

	@Test
	public void 숫자_두개의합() {
		String number = "1,2";
		int result = StringCalculator.add(number);

		assertThat(result).isEqualTo(3);
	}

	@Test
	public void 여러_디폴트_구분자가_존재() {
		String number = "1:2,3";
		int result = StringCalculator.add(number);

		assertThat(result).isEqualTo(6);
	}

// 	* 2. 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다. @Test
	@Test
	public void 커스텀_구분자() {
		String number = "//;\n1;2;3";
		int result = StringCalculator.add(number);

		assertThat(result).isEqualTo(6);
	}

	@Test(expected = IllegalArgumentException.class)
	public void 숫자가_아닐때_검증() {
		String number = "r";

		StringCalculator.add(number);
	}

	@Test(expected = IllegalArgumentException.class)
	public void 음수_검증() {
		String number = "-1";

		StringCalculator.add(number);
	}
}
