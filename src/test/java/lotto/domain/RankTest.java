package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public final class RankTest {
	@DisplayName("일치하는 로또 개수에 따라 해당 등수가 몇 장인지 센다. result는 1등, 2등, 3등, 4등, 5등 장수를 가진 배열")
	@Test
	void 이등_5개일치와_보너스일치가_2장_당첨됨() {
		List<MatchingNumbers> matchingNumbersList = new ArrayList<>();
		matchingNumbersList.add(new MatchingNumbers(5, true));
		matchingNumbersList.add(new MatchingNumbers(5, true));
		int[] result = Rank.calculate(matchingNumbersList);

		assertThat(result[2] == 2).isTrue();
	}
}
