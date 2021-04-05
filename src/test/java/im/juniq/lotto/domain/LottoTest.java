package im.juniq.lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import java.util.stream.StreamSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
	@Test
	void create() {
		Lotto lotto = new Lotto();

		assertThat(lotto.numbers().size()).isEqualTo(6);
	}

	@Test
	void createByString() {
		assertThat(new Lotto("1,2,3,4,5,6")).usingRecursiveComparison().isEqualTo(new Lotto(new NoShuffleStrategy()));
	}

	@Test
	void checkDuplicateNumbers() {
		Lotto lotto = new Lotto();
		long distinctNumberSize = StreamSupport.stream(lotto.numbers().spliterator(), false)
				.distinct()
				.count();

		assertThat(distinctNumberSize).isEqualTo(lotto.numbers().size());
	}

	@Test
	void equals() {
		Lotto lottoA = new Lotto(new NoShuffleStrategy());
		Lotto lottoB = new Lotto(new NoShuffleStrategy());

		assertThat(lottoA).usingRecursiveComparison().isEqualTo(lottoB);
	}

	@Test
	@DisplayName("당첨등수 조회")
	void winning() {
		Lotto lotto = new Lotto(new NoShuffleStrategy());

		assertThat(lotto.winning(new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7))).isEqualTo(Winning.FIRST);
		assertThat(lotto.winning(new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 7), 6))).isEqualTo(Winning.SECOND);
		assertThat(lotto.winning(new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 7), 8))).isEqualTo(Winning.THIRD);
		assertThat(lotto.winning(new WinningNumbers(Arrays.asList(1, 2, 3, 4, 7, 8), 9))).isEqualTo(Winning.FOURTH);
		assertThat(lotto.winning(new WinningNumbers(Arrays.asList(1, 2, 3, 7, 8, 9), 10))).isEqualTo(Winning.FIFTH);
		assertThat(lotto.winning(new WinningNumbers(Arrays.asList(1, 2, 7, 8, 9, 10), 11))).isEqualTo(Winning.LOSING);
		assertThat(lotto.winning(new WinningNumbers(Arrays.asList(1, 7, 8, 9, 10, 11), 12))).isEqualTo(Winning.LOSING);
		assertThat(lotto.winning(new WinningNumbers(Arrays.asList(7, 8, 9, 10, 11, 12), 13))).isEqualTo(Winning.LOSING);
	}

	@Test
	@DisplayName("당첨금 조회")
	void prize() {
		Lotto lotto = new Lotto(new NoShuffleStrategy());

		assertThat(lotto.prize(new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7))).isEqualTo(Winning.FIRST.amount());
		assertThat(lotto.prize(new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 7), 6))).isEqualTo(Winning.SECOND.amount());
		assertThat(lotto.prize(new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 7), 8))).isEqualTo(Winning.THIRD.amount());
		assertThat(lotto.prize(new WinningNumbers(Arrays.asList(1, 2, 3, 4, 7, 8), 9))).isEqualTo(Winning.FOURTH.amount());
		assertThat(lotto.prize(new WinningNumbers(Arrays.asList(1, 2, 3, 7, 8, 9), 10))).isEqualTo(Winning.FIFTH.amount());
		assertThat(lotto.prize(new WinningNumbers(Arrays.asList(1, 2, 7, 8, 9, 10), 11))).isEqualTo(Winning.LOSING.amount());
		assertThat(lotto.prize(new WinningNumbers(Arrays.asList(1, 7, 8, 9, 10, 11), 12))).isEqualTo(Winning.LOSING.amount());
		assertThat(lotto.prize(new WinningNumbers(Arrays.asList(7, 8, 9, 10, 11, 12), 13))).isEqualTo(Winning.LOSING.amount());
	}
}
