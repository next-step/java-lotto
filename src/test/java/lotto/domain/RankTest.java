package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

	@DisplayName("등수를 매긴다")
	@ParameterizedTest
	@CsvSource({"6, 0, FIRST", "5, 1, SECOND", "5, 0, THIRD", "4, 1, FOURTH", "3, 0, FIFTH", "1, 1, LOSING"})
	void matchedCountExist_Then_IllegalArgumentException(long matchedCount, long matchedBonusCount, Rank expected) {
		Rank rank = Rank.findByMatchedCount(matchedCount, matchedBonusCount);
		assertThat(rank).isEqualTo(expected);
	}
}
