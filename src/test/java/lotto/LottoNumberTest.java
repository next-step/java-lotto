package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LottoNumberTest {

	@Test
	void number_생성_성공() {
		LottoNumber number1 = new LottoNumber(1);
		assertThat(number1).isEqualTo(new LottoNumber(1));
		LottoNumber number45 = new LottoNumber(45);
		assertThat(number45).isEqualTo(new LottoNumber(45));
	}

	@Test
	void number_생성_실패() {
		assertThatThrownBy(() -> new LottoNumber(0))
			.isInstanceOf(RuntimeException.class);
		assertThatThrownBy(() -> new LottoNumber(46))
			.isInstanceOf(RuntimeException.class);
	}
}
