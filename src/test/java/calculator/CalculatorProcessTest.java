package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorProcessTest {

	@DisplayName("더하기")
	@Test
	public void sum() {

	}

	@DisplayName("빼기")
	@Test
	public void minus() {

	}

	@DisplayName("곱하기")
	@Test
	public void multiple() {

	}

	@DisplayName("나누기")
	@Test
	public void divide() {

	}

	@DisplayName("범위를 벗어난 입력값")
	@Test
	public void inputBoundError() {
		assertThatExceptionOfType(IndexOutOfBoundsException.class)
			.isThrownBy(() -> {
				// ...
			}).withMessageMatching("Index: \\d+, Size: \\d+");
	}

	@DisplayName("올바른 형식이 아닌 입력값")
	@Test
	public void inputIllegalInputError() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			// ...
		});
	}

	@DisplayName("빈문자 입력값")
	@ParameterizedTest
	@ValueSource(strings = {"", "  "})
	void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
		//assertTrue(Strings.isBlank(input));
	}

}
