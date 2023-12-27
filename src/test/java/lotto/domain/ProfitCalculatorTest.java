package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public final class ProfitCalculatorTest {
	@DisplayName("등수마다 일치하는 로또 개수 반환.")
	@Test
	void 등수마다_일치하는_로또_개수() {
		int[] numbersOfMatch = {1, 2, 3, 4, 5};
		int[] result = ProfitCalculator.calculate(numbersOfMatch);

		assertThat(result[2] == 1).isTrue();
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
