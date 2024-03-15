package calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MinusTest {
	@DisplayName("빼기 테스트")
	@Test
	void minus() {
		// given
		Minus minus = new Minus(4, 2);

		// when& then
		assertThat(minus.calculate()).isEqualTo(2);
	}
}
