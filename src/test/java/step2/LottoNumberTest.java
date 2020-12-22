package step2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step2.domain.LottoNumber;
import step2.domain.LottoNumbers;

public class LottoNumberTest {

	@DisplayName("로또번호 범위 테스트 - 최소 경계값 0")
	@Test
	void given_0_when_new_lotto_then_throw_exception() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			LottoNumber lottoNumber = new LottoNumber(0);
		});
	}

	@DisplayName("로또번호 범위 테스트 - 최대 경계값 0")
	@Test
	void given_46_when_new_lotto_then_throw_exception() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			LottoNumber lottoNumber = new LottoNumber(46);
		});
	}

	@DisplayName("로또 번호 일급 콜렉션 객체 LottoResults 크기가 클 경우 테스트")
	@Test
	void given_lotto_numbers_when_over_size_then_throw_exception() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			LottoNumbers lottoNumbers = new LottoNumbers(1,2,3,4,5,6,7);
		});
	}

	@DisplayName("로또 번호 일급 콜렉션 객체 LottoResults 크기가 작을 경우 테스트")
	@Test
	void given_lotto_numbers_when_less_size_then_throw_exception() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			LottoNumbers lottoNumbers = new LottoNumbers(1,2,3,4,5);
		});
	}

}
