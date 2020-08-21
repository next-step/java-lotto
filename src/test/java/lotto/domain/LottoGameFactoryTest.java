package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static lotto.domain.LottoGame.NUMBER_COUNT_PER_GAME;
import static org.assertj.core.api.Assertions.assertThat;


class LottoGameFactoryTest {

	@Test
	void newGameTest() {
		LottoGame newLottoGame = LottoGameFactory.getNewLottoGame();
		long validRangeCount = IntStream.rangeClosed(1, 45)
										.mapToObj(num -> newLottoGame.contains(new LottoNumber(num)))
										.filter(aBoolean -> aBoolean)
										.count();
		assertThat(validRangeCount).isEqualTo(NUMBER_COUNT_PER_GAME);
	}
}
