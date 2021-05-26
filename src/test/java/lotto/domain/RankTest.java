package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("순위 테스트")
public class RankTest {

	@Test
	@DisplayName("로또번호 일치개수와 보너스번호 일치여부에 따른 순위 확인 테스트")
	void rankTest() {
		Assertions.assertThat(Rank.findRank(6, false)).isEqualTo(Rank.FIRST);
		Assertions.assertThat(Rank.findRank(5, true)).isEqualTo(Rank.SECOND);
		Assertions.assertThat(Rank.findRank(5, false)).isEqualTo(Rank.THIRD);
		Assertions.assertThat(Rank.findRank(4, false)).isEqualTo(Rank.FOURTH);
		Assertions.assertThat(Rank.findRank(3, false)).isEqualTo(Rank.FIFTH);
		Assertions.assertThat(Rank.findRank(2, false)).isEqualTo(Rank.NONE);
		Assertions.assertThat(Rank.findRank(1, false)).isEqualTo(Rank.NONE);
	}

	@Test
	@DisplayName("순위의 순서를 확인하는 테스트")
	void isGreaterThen() {
		Assertions.assertThat(Rank.FIRST.isGreaterThan(Rank.SECOND)).isTrue();
		Assertions.assertThat(Rank.SECOND.isGreaterThan(Rank.THIRD)).isTrue();
		Assertions.assertThat(Rank.THIRD.isGreaterThan(Rank.FOURTH)).isTrue();
		Assertions.assertThat(Rank.FOURTH.isGreaterThan(Rank.FIFTH)).isTrue();
		Assertions.assertThat(Rank.FIFTH.isGreaterThan(Rank.NONE)).isTrue();
	}

}
