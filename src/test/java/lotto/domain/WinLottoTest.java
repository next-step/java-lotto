package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinLottoTest {
	@DisplayName("당첨 로또 NULL값 테스트")
	@Test
	public void winLottoNullTest() {
		assertThatIllegalArgumentException().isThrownBy(() -> new WinLotto(null, 1));
	}

	@DisplayName("당첨 로또 1 ~ 45 사이 숫자 테스트")
	@Test
	public void winLottoNumberTest() {
		assertThatIllegalArgumentException().isThrownBy(() -> new WinLotto(Arrays.asList(-100, 1, 2, 3, 4, 5), 6));
		assertThatIllegalArgumentException().isThrownBy(() -> new WinLotto(Arrays.asList(1000, 1, 2, 3, 4, 5), 7));
	}

	@DisplayName("당첨 로또 보너스 1 ~ 45 사이 숫자 테스트")
	@Test
	public void winLottoBonusNumberTest() {
		assertThatIllegalArgumentException().isThrownBy(() -> new WinLotto(Arrays.asList(6, 1, 2, 3, 4, 5), 10000));
		assertThatIllegalArgumentException().isThrownBy(() -> new WinLotto(Arrays.asList(8, 1, 2, 3, 4, 5), -1000));
	}
}