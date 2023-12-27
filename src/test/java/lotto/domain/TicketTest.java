package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TicketTest {
	@DisplayName("티켓의 첫번째 번호들과 당첨번호를 비교해서 맞힌 개수를 반환한다.")
	@Test
	void 티켓의_첫번째_번호들과_당첨번호를_비교해서_맞힌_개수를_반환한다() {
		int[] winningNumbers = {1, 2, 3, 4, 5, 7};
		List<Lotto> lottoList = Arrays.asList(new Lotto(1), new Lotto(2),
			new Lotto(3), new Lotto(4), new Lotto(5), new Lotto(6));
		Lottos lottos = new Lottos(lottoList);
		List<Lottos> lottosList = List.of(lottos);
		Ticket ticket = new Ticket(lottosList);

		assertThat(ticket.compareTo(winningNumbers, 0)).isEqualTo(5);
	}
}
