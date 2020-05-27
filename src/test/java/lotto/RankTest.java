package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RankTest {

	@DisplayName("일치 개수가 랭킹 구간 내에 존재하면 등수를 매길 수 있다")
	@ParameterizedTest
	@CsvSource({"6, First", "3, Fourth", "1, Losing", "0, Losing"})
	void matchedCountExist_Then_IllegalArgumentException(long matchedCount, Rank expected) {
		Rank rank = Rank.findByMatchedCount(matchedCount);
		assertThat(rank).isEqualTo(expected);
	}

	@DisplayName("일치 개수가 랭킹 구간 내에 존재하지 않으면 IllegalArgumentException")
	@Test
	void matchedCountNotExist_Then_IllegalArgumentException() {
		assertThatThrownBy(() -> Rank.findByMatchedCount(-1))
				.isInstanceOf(IllegalArgumentException.class);
	}
}