package im.juniq.lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoTest {
	@Test
	void create() {
		Lotto lotto = new Lotto();

		assertThat(lotto.numbers().size()).isEqualTo(6);
	}

	@Test
	void checkDuplicateNumbers() {
		Lotto lotto = new Lotto();

		long distinctNumberSize = lotto.numbers().stream()
			.distinct()
			.count();

		assertThat(distinctNumberSize).isEqualTo(lotto.numbers().size());
	}
}
