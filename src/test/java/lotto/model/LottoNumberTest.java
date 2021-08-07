package lotto.model;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

	@Test
	@DisplayName("로또번호를 저장하면 로또번호를 반환한다.")
	public void createLottoNumber(){
		LottoNumber lottoNumber1 = new LottoNumber(1);
		int resultLottoNumber1 = lottoNumber1.getLottoNumber();

		assertThat(resultLottoNumber1).isEqualTo(1);
		assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber(1));
	}
}