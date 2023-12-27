package lotto.controller;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Ticket;

public final class WinningNumberCheckerTest {
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

		int[] result = WinningNumberChecker.check(winningNumbers, ticket, number);

		assertThat(result[0] == 6).isTrue();
	}
}
