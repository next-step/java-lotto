package lotto;

import static java.util.stream.Collectors.toList;

import java.util.List;

public class Lottos {

	private List<Lotto> lottos;

	private Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public static Lottos of(List<Lotto> lottos) {
		return new Lottos(lottos);
	}

	public List<Ranking> getRankings(WinningBalls winningBalls) {
		return lottos.stream()
					 .map(lottoOfUser -> WinningArgument.of(lottoOfUser, winningBalls))
					 .map(Ranking::getRakingOf)
					 .collect(toList());
	}

	public int getPurchaseLottoCount() {
		return lottos.size();
	}

	public List<LottoNumbersDto> getLottoNumbers() {
		return lottos.stream()
					 .map(lotto -> lotto.toLottoNumbersDto())
					 .collect(toList());
	}
}
