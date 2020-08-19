package step3.domain;

import org.junit.jupiter.api.Test;
import step3.domain.LottoGame;
import step3.domain.LottoGameFactory;
import step3.domain.LottoNumber;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static step3.configuration.LottoConfig.NUMBER_COUNT_PER_GAME;

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
