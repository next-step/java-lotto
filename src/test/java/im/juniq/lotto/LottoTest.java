package im.juniq.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

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

	@Test
	void equals() {
		Lotto lottoA = new Lotto(new NoShuffleStrategy());
		Lotto lottoB = new Lotto(new NoShuffleStrategy());

		assertThat(lottoA).isEqualToComparingFieldByField(lottoB);
	}

	@Test
	void checkWinningNumber() {
		Lotto lotto = new Lotto(new NoShuffleStrategy());

		assertThat(lotto.numberOfMatchedWinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6))).isEqualTo(6);
		assertThat(lotto.numberOfMatchedWinningNumber(Arrays.asList(1, 2, 3, 4, 5, 7))).isEqualTo(5);
		assertThat(lotto.numberOfMatchedWinningNumber(Arrays.asList(1, 2, 4, 5, 7, 9))).isEqualTo(4);
		assertThat(lotto.numberOfMatchedWinningNumber(Arrays.asList(15, 9, 8, 5, 3, 1))).isEqualTo(3);
	}
}
