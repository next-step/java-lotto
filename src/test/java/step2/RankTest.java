package step2;


import static step2.model.Rank.FIFTH;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import step2.model.Rank;

public class RankTest {

	@Test
	void 등급_반환_테스트() {
		int countOfMatch = 3;
		Assertions.assertThat(Rank.of(countOfMatch)).isEqualTo(FIFTH);
		}

}
