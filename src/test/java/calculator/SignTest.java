package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class SignTest {
	@Test
	@DisplayName("생성자_사칙연산 외 기호_throw IllegalArgumentException")
	void new_sign() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			Sign sign = new Sign(",");
		}).withMessage("사칙연산 기호가 아닙니다.");
	}

	@Test
	@DisplayName("isPlusSign_덧셈 기호로 생성_true")
	void sign_isPlusSign() {
		Sign sign = new Sign("+");
		assertThat(sign.isPlusSign()).isTrue();
	}

	@Test
	@DisplayName("isMinusSign_뺄셈 기호로 생성_true")
	void sign_isMinusSign() {
		Sign sign = new Sign("-");
		assertThat(sign.isMinusSign()).isTrue();
	}

	@Test
	@DisplayName("isMultiplicationSign_곱셈 기호로 생성_true")
	void sign_isMultiplicationSign() {
		Sign sign = new Sign("*");
		assertThat(sign.isMultiplicationSign()).isTrue();
	}

	@Test
	@DisplayName("isDivisionSign_나눗셈 기호로 생성_true")
	void sign_isDivisionSign() {
		Sign sign = new Sign("/");
		assertThat(sign.isDivisionSign()).isTrue();
	}
}
