package calculator.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PositiveTest {

	@ParameterizedTest
	@DisplayName("양수: 정상 수 입력 객체 생성 테스트")
	@ValueSource(strings = {"10", "2", "5024", "495024"})
	void initPositiveTest(String userInput) {

		Positive positive = new Positive(userInput);

		assertThat(positive).isEqualTo(new Positive(userInput));
	}

	@Test
	@DisplayName("양수: 음수 입력 예외처리 테스트")
	void initExceptionTest() {

		assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> new Positive("-5"));
	}

	@Test
	@DisplayName("양수: null 또는 빈값 예외처리 테스트")
	void initEmptyTest() {

		assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> new Positive(null));
		assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> new Positive(""));
	}
}
