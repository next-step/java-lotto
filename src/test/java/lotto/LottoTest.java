package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
	private static final Lotto lotto = new Lotto(new AutoLottoNumberStrategy());

	@Test
	void 여섯개의_숫자가_존재() {
		assertThat(lotto.getLottoNumbers()).hasSize(6);
	}
}
