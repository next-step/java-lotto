package im.juniq.lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import im.juniq.lotto.domain.Lotto;
import im.juniq.lotto.domain.Lottoes;
import im.juniq.lotto.domain.NoShuffleStrategy;
import im.juniq.lotto.domain.Price;
import im.juniq.lotto.domain.Winning;
import im.juniq.lotto.domain.WinningNumbers;

class LottoesTest {
	@Test
	void createOne() {
		NoShuffleStrategy shuffleStrategy = new NoShuffleStrategy();
		assertThat(new Lottoes(1, shuffleStrategy)).usingRecursiveComparison().isEqualTo(
			new Lottoes(new Lotto(shuffleStrategy)));
	}

	@ParameterizedTest
	@ValueSource(ints = {2, 5, 14})
	void createTwo(int numberOfCreated) {
		NoShuffleStrategy shuffleStrategy = new NoShuffleStrategy();
		List<Lotto> lottoes = new ArrayList<>();
		for (int i = 0; i < numberOfCreated; i++) {
			lottoes.add(new Lotto(new NoShuffleStrategy()));
		}

		assertThat(new Lottoes(numberOfCreated, shuffleStrategy)).usingRecursiveComparison().isEqualTo(
			new Lottoes(lottoes));
	}

	@Test
	void countMatchedLottoes() {
		Lottoes lottoes = new Lottoes(2, new NoShuffleStrategy());

		assertThat(lottoes.numberOfLottoesMatched(Winning.FIFTH, new WinningNumbers(Arrays.asList(1, 2, 3, 7, 8, 9), 10))).isEqualTo(2);
		assertThat(lottoes.numberOfLottoesMatched(Winning.FOURTH, new WinningNumbers(Arrays.asList(1, 2, 3, 4, 8, 9), 10))).isEqualTo(2);
	}

	@Test
	void calculateYield() {
		Lottoes lottoes = new Lottoes(1, new NoShuffleStrategy());

		assertThat(lottoes.yield(new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7), new Price(1000))).isEqualTo(2000000);
		assertThat(lottoes.yield(new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 7), 6), new Price(1000))).isEqualTo(30000);
		assertThat(lottoes.yield(new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 7), 8), new Price(1000))).isEqualTo(1500);
		assertThat(lottoes.yield(new WinningNumbers(Arrays.asList(1, 2, 3, 4, 7, 8), 6), new Price(1000))).isEqualTo(50);
		assertThat(lottoes.yield(new WinningNumbers(Arrays.asList(1, 2, 3, 7, 8, 9), 6), new Price(1000))).isEqualTo(5);
	}
}
