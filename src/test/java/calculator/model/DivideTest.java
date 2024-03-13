package calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class DivideTest {
	@DisplayName("나누기 테스트")
	@Test
	void divide() {
		// given
		Divide divide = new Divide(4, 2);

		// when& then
		assertThat(divide.calculate()).isEqualTo(2);
	}

	@DisplayName("0으로 나눌때 예외처리 테스트")
	@Test
	void divideWithZero() {
		// given
		Divide divide = new Divide(4, 0);

		// when& then
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> {
					divide.calculate();
				}).withMessageMatching("0으로 나눌 수 없습니다. 0보다 큰 숫자를 입력해주세요.");
	}
}
