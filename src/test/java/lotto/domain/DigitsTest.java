package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DigitsTest {
	@DisplayName("숫자 배열을 포장.")
	@Test
	void 숫자_배열을_포장() {
		int[] numbers = new int[]{1,2,3,4,5,6};
		Digit result = new Digit(1);

		assertThat(Digits.create(numbers).contains(result)).isTrue();
	}

	@DisplayName("Digit를 문자열로 변환.")
	@Test
	void Digit를_문자열로_변환() {
		int[] numbers = new int[]{1,2,3,4,5,6};

		assertThat(new Digits(Digits.create(numbers)).digitToString().get(0).equals("1")).isTrue();
	}
}
