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
	@DisplayName("of_String +_Sign.PLUS")
	void plus_정상반환() {
		assertThat(Sign.of("+")).isEqualTo(Sign.PLUS);
	}

	@Test
	@DisplayName("calculate_덧셈_덧셈 결과값")
	void calculate_plus() {
		assertThat(Sign.PLUS.calculate(1, 2)).isEqualTo(3);
	}

	@Test
	@DisplayName("of_String -_Sign.MINUS")
	void minus_정상반환() {
		assertThat(Sign.of("-")).isEqualTo(Sign.MINUS);
	}

	@Test
	@DisplayName("calculate_뺄셈_뺄셈 결과값")
	void calculate_minus() {
		assertThat(Sign.MINUS.calculate(2, 1)).isEqualTo(1);
	}

	@Test
	@DisplayName("of_String *_Sign.MULTIPLICATION")
	void multiplication_정상반환() {
		assertThat(Sign.of("*")).isEqualTo(Sign.MULTIPLICATION);
	}

	@Test
	@DisplayName("calculate_곱셈_곱셈 결과값")
	void calculate_multiplication() {
		assertThat(Sign.MULTIPLICATION.calculate(3, 2)).isEqualTo(6);
	}

	@Test
	@DisplayName("of_String /_Sign.DIVISION")
	void division_정상반환() {
		assertThat(Sign.of("/")).isEqualTo(Sign.DIVISION);
	}

	@Test
	@DisplayName("calculate_나눗셈_나눗셈 결과값")
	void calculate_division() {
		assertThat(Sign.DIVISION.calculate(3, 2)).isEqualTo(1);
	}
}
