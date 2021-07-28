package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

	@DisplayName("로또 번호는 1 ~ 45 사이의 숫자를 갖는다.")
	@ValueSource(ints = {1, 45})
	@ParameterizedTest
	void valid(int number) {
		LottoNumber lottoNumber = new LottoNumber(number);
		assertThat(lottoNumber.getNumber()).isEqualTo(number);
	}
	
	@DisplayName("1 ~ 45 사이 외의 숫자로 로또 번호를 생성할 경우 IllegalArgumentException 예외가 발생한다.")
	@ValueSource(ints = {-1, 0, 46})
	@ParameterizedTest
	void invalid(int number) {
		assertThatThrownBy(() -> new LottoNumber(number))
			.isInstanceOf(IllegalArgumentException.class);
	}

}
