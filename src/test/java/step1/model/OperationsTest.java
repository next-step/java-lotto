package step1.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperationsTest {

	@ParameterizedTest
	@DisplayName("잘못 입력된 input 값에 대해서는 Exception을 내뱉는다.")
	@ValueSource(strings = {"abcd"})
	@NullAndEmptySource
	void checkOperationStatus(String input) {
		assertThatThrownBy(() -> new Operations(input)).isInstanceOf(IllegalArgumentException.class);
	}
}