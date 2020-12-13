package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author : byungkyu
 * @date : 2020/12/13
 * @description :
 **/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LottoNumberTest {

	@Order(1)
	@DisplayName("1. 로또 숫자의 범위는 1부터 46까지 이다")
	@ParameterizedTest
	@ValueSource(ints = {1, 10, 20, 30, 40, 46})
	void lottoNumberIsOneToFortySix(int number) {
		LottoNumber lottoNumber = new LottoNumber(number);
		assertThat(lottoNumber.getNumber()).isEqualTo(number);
	}

	@Order(2)
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
