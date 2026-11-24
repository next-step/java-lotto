package domain.lotto;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

	@ParameterizedTest
	@ValueSource(ints = {0, 46})
	void 로또_숫자는_1부터_45이하이다(int number) {
		Assertions.assertThatThrownBy(() -> new LottoNumber(number))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 45})
	void 로또_숫자는_1과_45를_허용한다(int number) {
		LottoNumber lottoNumber = new LottoNumber(number);
		assertThat(lottoNumber.getNumber()).isEqualTo(number);
	}
}
