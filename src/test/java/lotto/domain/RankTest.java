package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RankTest {

	@DisplayName("적절한 랭크를 반환한다.")
	@CsvSource(value = {"6,false,FIRST", "5,true,SECOND", "5,false,THIRD", "4,true,FOURTH", "3,false,FIFTH", "2,true,MISS", "1,false,MISS", "0,true,MISS"}, delimiter = ',')
	@ParameterizedTest
	void test1(int matchCount, boolean matchBonus, Rank rank) {
		assertThat(Rank.of(matchCount, matchBonus)).isEqualTo(rank);
	}
}
