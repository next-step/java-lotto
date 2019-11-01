package lotto.domain.lotto;

import lotto.domain.person.Wallet;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class LottoCreatorTest {

	@Test
	void 로또가_생기면_중첩되지_않은_6자리_숫자를_가진다() {
		// given
		LottoCreator lottoCreator = LottoCreator.of(new RandomLottoNumberGenerator());

		// when
		Lotto lotto = lottoCreator.pickLotto(Wallet.of(1000L));

		// then
		assertThat(lotto.getNumbers()).isInstanceOf(Set.class);
		assertThat(lotto.getNumbers()).hasSize(6);
	}

}
