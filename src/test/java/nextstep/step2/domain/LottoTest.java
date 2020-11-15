package nextstep.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class LottoTest {
	@Test
	@DisplayName("로또 번호는 1~45 사이의 수이다.")
	public void getLottoNumbersTest() {
		Lotto lotto = new Lotto(new LottoAutoGenerator());
		assertThat(lotto.getLottoNumbers()).hasSize(6);
		assertAll(() -> assertFalse(lotto.getLottoNumbers().contains(0)),
				() -> assertFalse(lotto.getLottoNumbers().contains(46)));
	}
}
