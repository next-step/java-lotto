package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("순위 테스트")
public class RankTest {

	@Test
	@DisplayName("일치 개수별 순위 확인 테스트")
	void rankTest() {
		Assertions.assertThat(Rank.findRankByMatchCount(6)).isEqualTo(Rank.FIRST);
		Assertions.assertThat(Rank.findRankByMatchCount(5)).isEqualTo(Rank.SECOND);
		Assertions.assertThat(Rank.findRankByMatchCount(4)).isEqualTo(Rank.THIRD);
		Assertions.assertThat(Rank.findRankByMatchCount(3)).isEqualTo(Rank.FOURTH);
		Assertions.assertThat(Rank.findRankByMatchCount(2)).isEqualTo(Rank.NONE);
		Assertions.assertThat(Rank.findRankByMatchCount(1)).isEqualTo(Rank.NONE);
	}

	@Test
	@DisplayName("일치하는 개수보다 큰지 확인 테스트")
	void isGreaterThen() {
		Assertions.assertThat(Rank.FIRST.isGreaterThan(Rank.SECOND)).isTrue();
		Assertions.assertThat(Rank.SECOND.isGreaterThan(Rank.THIRD)).isTrue();
		Assertions.assertThat(Rank.THIRD.isGreaterThan(Rank.FOURTH)).isTrue();
		Assertions.assertThat(Rank.FOURTH.isGreaterThan(Rank.NONE)).isTrue();
	}

}
