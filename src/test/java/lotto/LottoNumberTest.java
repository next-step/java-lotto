package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

	@Test
	@DisplayName(value = "숫자를 할당 받으면 로또 넘버가 만들어진다")
	void createLottoNumber() {
		LottoNumber lottoNumber = new LottoNumber(5);
		assertThat(lottoNumber.number()).isEqualTo(5);
	}

	@Test
	@DisplayName(value = "로또 범위를 벗어나면 exception을 일으킨다")
	void oneTo46() {
		assertThrows(IllegalArgumentException.class,
			() -> new LottoNumber(47));
		assertThrows(IllegalArgumentException.class,
			() -> new LottoNumber(0));
	}

}
