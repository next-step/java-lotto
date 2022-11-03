package step2;


import static org.assertj.core.api.Assertions.assertThat;
import static step2.model.Rank.FIFTH;
import static step2.model.Rank.SECOND;
import static step2.model.Rank.THIRD;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperties;
import step2.model.Rank;

public class RankTest {
	@Test
	@DisplayName("2등은 30_000_000이 상금이다 ")
	void 가격_반환_테스트() {
		int countOfMatch = 5;
		assertThat(Rank.of(countOfMatch,true).getWinningMoney()).isEqualTo(30_000_000);
	}

	@Test
	@DisplayName("2등은 보너스번호와 5개를 맞춘다")
	void 등급_반환_테스트1() {
		int countOfMatch = 5;
		assertThat(Rank.of(countOfMatch,true)).isEqualTo(SECOND);
	}

	@Test
	@DisplayName("3등은 보너스 번호 제외 5개를 맞춘다")
	void 등급_반환_테스트2() {
		int countOfMatch = 5;
		assertThat(Rank.of(countOfMatch,false)).isEqualTo(THIRD);
	}


}
