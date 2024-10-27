package step1.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step1.exception.UserInputEmptyException;
import step1.exception.UserInputUnValidException;

class ExpressionTest {
	@Test
	@DisplayName("입력 값이 null 이거나 빈 공백 문자일 경우 throw 테스트")
	void isEmptyTest() {
		assertThatThrownBy(() -> {
			new Expression("");
		}).isInstanceOf(UserInputEmptyException.class);
	}

	@Test
	@DisplayName("숫자와 사칙연산 사이 빈 공백이 아니면 throw 테스트")
	void validSpaceTest() {
		assertThatThrownBy(() -> {
			new Expression("1+2");
		}).isInstanceOf(UserInputUnValidException.class);
	}

	@Test
	@DisplayName("사칙연산 기호가 아닌 특수문자일 경우 throw 테스트")
	void isValidOperatorTest() {
		assertThatThrownBy(() -> {
			new Expression("4 ? 2");
		}).isInstanceOf(UserInputUnValidException.class);
	}
}