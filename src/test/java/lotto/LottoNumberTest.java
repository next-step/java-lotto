package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.domain.LottoNumber;

public class LottoNumberTest {

	@DisplayName("단일 숫자 생성 테스트 : 정상 범위")
	@ParameterizedTest
	@ValueSource(ints = {1, 5, 6, 10, 15, 20, 30, 45})
	void numberMakeTest(int number) {
		LottoNumber lottoNumber = new LottoNumber(number);
		assertThat(lottoNumber).isEqualTo(new LottoNumber(number));
	}

	@DisplayName("단일 숫자 생성 테스트 : 정상 범위 ")
	@ParameterizedTest
	@ValueSource(ints = {-1, 0, 46, 47})
	void invalidNumberMakeTest(int number) {
		assertThatThrownBy(() -> {
			LottoNumber lottoNumber = new LottoNumber(number);
			assertThat(lottoNumber).isEqualTo(new LottoNumber(number));
		}).isInstanceOf(IllegalArgumentException.class);
	}

}
