package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public final class TicketTest {
	@DisplayName("티켓의 첫번째 번호들과 당첨번호를 비교해서 맞힌 개수를 반환한다.")
	@Test
	void 티켓의_첫번째_번호들과_당첨번호를_비교해서_맞힌_개수를_반환한다() {
		int[] winningNumbers = {1, 2, 3, 4, 5, 7};
		List<LottoNumber> lottoNumberList = Arrays.asList(new LottoNumber(1), new LottoNumber(2),
			new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
		Lotto lotto = new Lotto(lottoNumberList);
		List<Lotto> lottoList = List.of(lotto);
		Ticket ticket = new Ticket(lottoList);

		assertThat(ticket.compareTo(winningNumbers, 0)).isEqualTo(5);
	}

	@DisplayName("로또 번호 6개가 1세트 들어있는 티켓 생성.")
	@Test
	void 로또_번호_6개가_들어있는_1세트의_첫번째_로또_번호() {
		assertThat(Ticket.generate(1).get(0).indexOfLotto(0).isBetween(1, 45)).isTrue();
	}
}
