package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RankTest {

	@ParameterizedTest(name = "winningNumber = {0}, userNumber = {1}, bonusNumber = {2}")
	@CsvSource(value = {"1,2,3,4,5,6 : 1,2,3,4,5,6: 8"}, delimiter = ':')
	@DisplayName("1등 확인(6개 일치) 테스트")
	void first_rank_test(String winningNumbers, String userNumbers, int bonusNumber) {
		Lotto winningLotto = Lotto.createFromString(winningNumbers);
		Lotto userLotto = Lotto.createFromString(userNumbers);
		boolean matchBonus = userNumbers.contains(String.valueOf(bonusNumber));
		Rank rank = Rank.from(userLotto.matchCount(winningLotto), matchBonus);

		assertThat(rank).isEqualTo(Rank.FIRST);
	}

	@ParameterizedTest(name = "winningNumber = {0}, userNumber = {1}, bonusNumber = {2}")
	@CsvSource(value = {"1,2,3,4,5,7 : 1,2,3,4,5,6: 6"}, delimiter = ':')
	@DisplayName("2등 확인(5개 일치) 테스트")
	void second_rank_test(String winningNumbers, String userNumbers, int bonusNumber) {
		Lotto winningLotto = Lotto.createFromString(winningNumbers);
		Lotto userLotto = Lotto.createFromString(userNumbers);
		boolean matchBonus = userNumbers.contains(String.valueOf(bonusNumber));
		Rank rank = Rank.from(userLotto.matchCount(winningLotto), matchBonus);
		assertThat(rank).isEqualTo(Rank.SECOND);

	}

	@ParameterizedTest(name = "winningNumber = {0}, userNumber = {1}, bonusNumber = {2}")
	@CsvSource(value = {"1,2,3,4,5,7 : 1,2,3,4,5,6: 7"}, delimiter = ':')
	@DisplayName("3등 확인(5개 일치) 테스트")
	void third_rank_test(String winningNumbers, String userNumbers, int bonusNumber) {
		Lotto winningLotto = Lotto.createFromString(winningNumbers);
		Lotto userLotto = Lotto.createFromString(userNumbers);
		boolean matchBonus = userNumbers.contains(String.valueOf(bonusNumber));
		Rank rank = Rank.from(userLotto.matchCount(winningLotto), matchBonus);
		assertThat(rank).isEqualTo(Rank.THIRD);

	}
}
