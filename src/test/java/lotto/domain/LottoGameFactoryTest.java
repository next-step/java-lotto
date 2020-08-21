package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static lotto.domain.LottoGame.NUMBER_COUNT_PER_GAME;
import static org.assertj.core.api.Assertions.assertThat;


class LottoGameFactoryTest {

	@DisplayName("자동 생성된 로또 게임 숫자가 모두 1-45 범위에 들어가나 테스트")
	@Test
	void newGameTest() {
		LottoGame newLottoGame = LottoGameFactory.getNewAutoGame();
		long validRangeCount = IntStream.rangeClosed(1, 45)
										.mapToObj(num -> newLottoGame.contains(new LottoNumber(num)))
										.filter(aBoolean -> aBoolean)
										.count();
		assertThat(validRangeCount).isEqualTo(NUMBER_COUNT_PER_GAME);
	}


}
