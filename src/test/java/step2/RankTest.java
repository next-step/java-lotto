package step2;


import static org.assertj.core.api.Assertions.assertThat;
import static step2.model.Rank.FIFTH;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import step2.model.Rank;

public class RankTest {

	@Test
	void 등급_반환_테스트() {
		int countOfMatch = 3;
		assertThat(Rank.of(countOfMatch)).isEqualTo(FIFTH);
	}

	@Test
	void 가격_반환_테스트() {
		int countOfMatch = 5;
		assertThat(Rank.of(countOfMatch).getWinningMoney()).isEqualTo(30_000_000);
	}


}
