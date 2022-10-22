package step1.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorTest {

	@Test
	@DisplayName("잘못 입력된 input 값에 대해서는 Exception을 내뱉는다.")
	void checkOperationStatus() {
		assertThatThrownBy(() -> new Operator("")).isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> new Operator("abcd")).isInstanceOf(IllegalArgumentException.class);
	}
}