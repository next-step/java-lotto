package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LottoNumberTest {

	@Test
	void number_생성_성공() {
		LottoNumber number1 = LottoNumber.valueOf(1);
		assertThat(number1).isEqualTo(LottoNumber.valueOf(1));
		LottoNumber number45 = LottoNumber.valueOf(45);
		assertThat(number45).isEqualTo(LottoNumber.valueOf(45));
	}

	@Test
	void number_생성_실패() {
		assertThatThrownBy(() -> LottoNumber.valueOf(0))
			.isInstanceOf(RuntimeException.class);
		assertThatThrownBy(() -> LottoNumber.valueOf(46))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	void number_캐시_테스트() {
		LottoNumber number1 = LottoNumber.valueOf(10);
		LottoNumber number2 = LottoNumber.valueOf(10);
		assertThat(number1).isEqualTo(number2);
	}
}
