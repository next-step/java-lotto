package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public final class ProfitCalculatorTest {
	@DisplayName("일치하는 로또 개수에 따라 해당 등수가 몇 장인지 센다. result는 4등, 3등, 2등, 1등 장수를 가진 배열")
	@Test
	void 사등_3개일치_가_2장_당첨됨() {
		int[] numbersOfMatch = {1, 2, 3, 3, 5};
		int[] result = ProfitCalculator.calculate(numbersOfMatch);

		assertThat(result[0] == 2).isTrue();
	}

	@DisplayName("당첨 번호와 내 번호를 비교해서 일치하는 개수 반환")
	@Test
	void 당첨번호와_내번호를_비교해서_일치하는_개수_반환() {
		int number = 1;
		int[] winningNumbers = {1, 2, 3, 4, 5, 6};
		List<Lotto> lottoList = Arrays.asList(new Lotto(1), new Lotto(2),
			new Lotto(3), new Lotto(4), new Lotto(5), new Lotto(6));
		Lottos lottos = new Lottos(lottoList);
		List<Lottos> lottosList = List.of(lottos);
		Ticket ticket = new Ticket(lottosList);

		int[] result = ProfitCalculator.check(winningNumbers, ticket, number);

		assertThat(result[0] == 6).isTrue();
	}
}
