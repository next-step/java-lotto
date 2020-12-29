package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {
	@DisplayName("로또 번호 0 테스트")
	@Test
	public void lottoNumberZeroTest() {
		assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(0));
	}

	@DisplayName("로또 번호 음수 테스트")
	@Test
	public void lottoNumberNegativeTest() {
		assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(-1));
	}

	@DisplayName("로또 번호 45 초과 테스트")
	@Test
	public void lottoNumberLargeTest() {
		assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(46));
	}
	
	@DisplayName("로또 캐시 테스트")
	@Test
	public void lottoNumberCacheTest() {
		LottoNumber lottoNumber = LottoNumber.of(1);
		assertThat(lottoNumber == LottoNumber.of(1)).isTrue();
	}
}