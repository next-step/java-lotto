package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.domain.LottoNumber;

public class LottoNumberTest {

	@DisplayName("1 ~ 45 숫자로 생성되는지 확인한다.")
	@ParameterizedTest
	@ValueSource(ints = {1, 10, 45})
	void createTest(int source) {
		LottoNumber lottoNumber = LottoNumber.of(source);

		assertThat(lottoNumber.isSameNumber(source)).isTrue();
	}

	@DisplayName("1 ~ 45 이외에 숫자로 생성 시 예외 처리를 확인한다.")
	@ParameterizedTest
	@ValueSource(ints = {-10, 0, 46})
	void sizeValidateTest(int source) {
		assertThatThrownBy(() -> LottoNumber.of(source))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
