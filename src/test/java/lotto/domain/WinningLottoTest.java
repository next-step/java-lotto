package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public final class WinningLottoTest {
	@DisplayName("당첨 번호와 내 번호를 비교해서 일치하는 개수 반환")
	@Test
	void 당첨번호와_내번호를_비교해서_일치하는_개수_반환() {
		Lotto winningNumbers = new Lotto(1, 2, 3, 4, 5, 6);
		LottoNumber bonus = new LottoNumber(7);
		Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
		List<Lotto> lottoList = List.of(lotto);
		Ticket ticket = new Ticket(lottoList);
		WinningLotto winningLotto = new WinningLotto(winningNumbers, bonus);

		List<MatchingNumbers> result = winningLotto.match(ticket);

		assertThat(result.get(0).isMatching(6)).isTrue();
	}
}
