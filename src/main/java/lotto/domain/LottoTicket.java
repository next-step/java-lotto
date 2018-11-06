package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.enums.Prize;

public class LottoTicket {

	private List<Lotto> lottos;

	public LottoTicket(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public WinningResult win(WinningNumber winningNumber) {
		List<Prize> prizes = lottos.stream()
				.map(lotto -> winningNumber.match(lotto))
				.collect(Collectors.toList());
		return new WinningResult(prizes);
	}

	public List<Lotto> getLottos() {
		return lottos;
	}
}
