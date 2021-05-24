package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class NumberTest {

	@Test
	void number_생성_성공() {
		Number number1 = new Number(1);
		assertThat(number1).isEqualTo(new Number(1));
		Number number45 = new Number(45);
		assertThat(number45).isEqualTo(new Number(45));
	}

	@Test
	void number_생성_실패() {
		assertThatThrownBy(() -> new Number(0))
			.isInstanceOf(RuntimeException.class);
		assertThatThrownBy(() -> new Number(46))
			.isInstanceOf(RuntimeException.class);
	}
}
