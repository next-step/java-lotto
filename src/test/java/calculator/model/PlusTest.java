package calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlusTest {
	@DisplayName("더하기 테스트")
	@Test
	void plus() {
		// given
		Plus plus = new Plus(4, 2);

		// when& then
		assertThat(plus.calculate()).isEqualTo(6);
	}
}
