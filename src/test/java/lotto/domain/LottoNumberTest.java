package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또숫자 테스트")
public class LottoNumberTest {

	@Test
	@DisplayName("로또 숫자 생성 테스트")
	void createLottoNumber() {
		Assertions.assertThatThrownBy(() -> new LottoNumber(0))
				.isInstanceOf(IllegalArgumentException.class);

		Assertions.assertThatThrownBy(() -> new LottoNumber(46))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("당첨번호와 일치하는지 여부를 테스트")
	void equals() {
		LottoNumber lottoNumber = new LottoNumber(1);
		Assertions.assertThat(lottoNumber.equals(new LottoNumber(1))).isTrue();
		Assertions.assertThat(lottoNumber.equals(new LottoNumber(2))).isFalse();
	}

}
