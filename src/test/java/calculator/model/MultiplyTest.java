package calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MultiplyTest {
	@DisplayName("곱하기 테스트")
	@Test
	void multiply() {
		// given
		Multiply multiply = new Multiply(4, 2);

		// when& then
		assertThat(multiply.calculate()).isEqualTo(8);
	}
}
