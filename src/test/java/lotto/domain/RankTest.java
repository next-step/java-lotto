package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RankTest {

	@ParameterizedTest(name = "winningNumber = {0}, userNumber = {1}")
	@CsvSource(value = {"1,2,3,4,5,6 : 1,2,3,4,5,6"}, delimiter = ':')
	@DisplayName("1등 확인(6개 일치) 테스트")
	void first_rank_test(String winningNumbers, String userNumbers) {
		Lotto winningLotto = Lotto.of(winningNumbers);
		Lotto userLotto = Lotto.of(userNumbers);
		Rank rank = Rank.from(userLotto.matchCount(winningLotto));

		assertThat(rank).isEqualTo(Rank.FIRST);
	}
}
