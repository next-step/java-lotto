package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

	@ParameterizedTest
	@DisplayName("로또 숫자는 1~45 의 범위의 숫자 하나로 생성된다.")
	@ValueSource(ints = {1, 45})
	void createLottoNumberTest(int number) {
		LottoNumber lottoNumber = LottoNumber.of(number);

		assertThat(lottoNumber.getNumber()).isEqualTo(number);
	}

	@ParameterizedTest
	@DisplayName("1~45 범위 밖에 있는 숫자로 로또 숫자를 만들면 IllegalArgumentException 이 발생한다.")
	@ValueSource(ints = {0, 46})
	void validationRangeTest(int outOfRangeNumber) {
		assertThatThrownBy(() -> LottoNumber.of(outOfRangeNumber))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("동일한 숫자의 LottoNumber 를 요청시 같은 LottoNumber 객체를 반환한다.")
	void sameLottoNumberTest() {
		LottoNumber lottoNumber = LottoNumber.of(1);
		LottoNumber sameLottoNumber = LottoNumber.of(1);

		assertThat(lottoNumber).isSameAs(sameLottoNumber);
	}

}
