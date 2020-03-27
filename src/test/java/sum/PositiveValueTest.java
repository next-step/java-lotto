package sum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositiveValueTest {

	@Test
	@DisplayName("기본 테스트")
	void getValue() {
		assertThat(new PositiveValue(0).getValue())
				.isEqualTo(0);
	}

	@Test
	@DisplayName("객체 테스트")
	void objectTest() {
		assertThat(new PositiveValue(0))
				.isEqualTo(new PositiveValue(0));
	}

	@Test
	@DisplayName("예외 테스트")
	void exceptionTest() {
		assertThatThrownBy(() -> new PositiveValue(-1))
				.isInstanceOf(RuntimeException.class);
	}
}