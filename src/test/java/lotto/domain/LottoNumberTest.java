package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author : byungkyu
 * @date : 2020/12/13
 * @description :
 **/
public class LottoNumberTest {

	@DisplayName("1. 로또 숫자의 범위는 1부터 46까지 이다")
	@ParameterizedTest
	@ValueSource(ints = {1, 10, 20, 30, 40, 46})
	void lottoNumberIsOneToFortySix(int number) {
		LottoNumber lottoNumber = new LottoNumber(number);
		assertThat(lottoNumber.getNumber()).isEqualTo(number);
	}

	@DisplayName("1.1. 로또 숫자의 범위는 1부터 46까지 이다")
	@ParameterizedTest
	@ValueSource(ints = {0, 47})
	void lottoNumberIsOneToFortySixException(int number) {
		assertThatThrownBy(() -> {
			LottoNumber lottoNumber = new LottoNumber(number);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("로또 숫자의 범위는 1부터 46까지 입니다.");
	}
}
