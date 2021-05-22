package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

	@Test
	@DisplayName(value = "숫자를 할당 받으면 로또 넘버가 만들어진다")
	void createLottoNumber() {
		LottoNumber lottoNumber = new LottoNumber(5);
		assertThat(lottoNumber.number()).isEqualTo(5);
	}

}
