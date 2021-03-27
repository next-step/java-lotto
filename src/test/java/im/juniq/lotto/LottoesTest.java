package im.juniq.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
}
