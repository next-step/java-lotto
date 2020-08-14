package step2.domain;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static step2.configuration.LottoConfig.NUMBER_COUNT_PER_GAME;

class LottoGameFactoryTest {

	@Test
	void newGameTest() {
		LottoGame newLottoGame = LottoGameFactory.getNewLottoGame();
		long validRangeCount = IntStream.range(1, 46)
										.mapToObj(num -> newLottoGame.contains(new LottoNumber(num)))
										.filter(aBoolean -> aBoolean)
										.count();
		assertThat(validRangeCount).isEqualTo(NUMBER_COUNT_PER_GAME);
	}
}