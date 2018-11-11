package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.enums.Prize;

public class LottoTicket {

	private List<Lotto> lottos;

	public LottoTicket(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public static LottoTicket of(LottoTicket... lottoTickets) {
		List<Lotto> lottos = new ArrayList<>();
		for (LottoTicket lottoTicket : lottoTickets) {
			lottos.addAll(lottoTicket.lottos);
		}
		return new LottoTicket(lottos);
	}

	public WinningResult match(WinningLotto winningLotto) {
		List<Prize> prizes = lottos.stream()
				.map(lotto -> winningLotto.getPrize(lotto))
				.collect(Collectors.toList());
		return new WinningResult(prizes);
	}

	public List<Lotto> getLottos() {
		return lottos;
	}
}
