package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {
	@DisplayName("로또 번호 0 테스트")
	@Test
	public void lottoNumberZeroTest() {
		assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(0));
	}

	@DisplayName("로또 번호 음수 테스트")
	@Test
	public void lottoNumberNegativeTest() {
		assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(-1));
	}

	@DisplayName("로또 번호 45 초과 테스트")
	@Test
	public void lottoNumberLargeTest() {
		assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(46));
	}
}