package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class SignTest {

	@Test
	@DisplayName("of_사칙연산 외 기호, 사칙연산 기호_throw IllegalArgumentException, no Exception")
	void of() {
		assertThatThrownBy(() -> {
			Sign.of(",");
		}).isInstanceOf(IllegalArgumentException.class).hasMessage("사칙연산 기호가 아닙니다.");

		assertThatNoException().isThrownBy(() -> {
			Sign.of("+");
		});
	}

	@Test
	@DisplayName("calculate_덧셈 기호로 생성_덧셈 결과값")
	void calculate_plus() {
		Sign sign = Sign.of("+");
		assertThat(sign.calculate(1, 2)).isEqualTo(3);
	}

	@Test
	@DisplayName("calculate_뺄셈 기호로 생성_뺄셈 결과값")
	void calculate_minus() {
		Sign sign = Sign.of("-");
		assertThat(sign.calculate(2, 1)).isEqualTo(1);
	}

	@Test
	@DisplayName("calculate_곱셈 기호로 생성_곱셈 결과값")
	void calculate_multiplication() {
		Sign sign = Sign.of("*");
		assertThat(sign.calculate(3, 2)).isEqualTo(6);
	}

	@Test
	@DisplayName("calculate_나눗셈 기호로 생성_나눗셈 결과값")
	void calculate_division() {
		Sign sign = Sign.of("/");
		assertThat(sign.calculate(3, 2)).isEqualTo(1);
	}
}
