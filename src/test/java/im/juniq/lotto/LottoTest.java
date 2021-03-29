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

	@Test
	void equals() {
		Lotto lottoA = new Lotto(new NoShuffleStrategy());
		Lotto lottoB = new Lotto(new NoShuffleStrategy());

		assertThat(lottoA).isEqualToComparingFieldByField(lottoB);
	}

	@Test
	void winning() {
		Lotto lotto = new Lotto(new NoShuffleStrategy());

		assertThat(lotto.winning(new WinningNumbers(1, 2, 3, 4, 5, 6), 7)).isEqualTo(Winning.FIRST);
		assertThat(lotto.winning(new WinningNumbers(1, 2, 3, 4, 5, 7), 6)).isEqualTo(Winning.SECOND);
		assertThat(lotto.winning(new WinningNumbers(1, 2, 3, 4, 5, 7), 8)).isEqualTo(Winning.THIRD);
		assertThat(lotto.winning(new WinningNumbers(1, 2, 3, 4, 7, 8), 9)).isEqualTo(Winning.FOURTH);
		assertThat(lotto.winning(new WinningNumbers(1, 2, 3, 7, 8, 9), 10)).isEqualTo(Winning.FIFTH);
		assertThat(lotto.winning(new WinningNumbers(1, 2, 7, 8, 9, 10), 11)).isEqualTo(Winning.LOSING);
		assertThat(lotto.winning(new WinningNumbers(1, 7, 8, 9, 10, 11), 12)).isEqualTo(Winning.LOSING);
		assertThat(lotto.winning(new WinningNumbers(7, 8, 9, 10, 11, 12), 13)).isEqualTo(Winning.LOSING);
	}
}
