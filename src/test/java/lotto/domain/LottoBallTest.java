package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.domain.LottoBall;

class LottoBallTest {
	@ParameterizedTest
	@ValueSource(ints = {1, 22, 45})
	void 로또공_클래스에_번호를_부여할_수_있다(int number) {
		LottoBall lottoBall = LottoBall.from(number);
		assertThat(lottoBall).isNotNull();
		assertThat(lottoBall).isEqualTo(new LottoBall(number));
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 46})
	void 로또공_클래스_생성자에_1과45이외의_값을_입력받으면_예외를_던진다(int number) {
		assertThatThrownBy(() -> new LottoBall(number)).isInstanceOf(RuntimeException.class);
	}

	@Test
	void test111() {
		String input = "1,2,3,4,5,6";
		System.out.println(Arrays.toString(input.split(",")));

		input = "1, 2, 3, 4, 5, 6";
		System.out.println(Arrays.toString(input.split(",")));
	}
}
