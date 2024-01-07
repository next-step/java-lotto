package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public final class Lottos {
	private final List<Lotto> lottos = new ArrayList<>();

	public void addManualLotto(final List<String> stringLottos) {
		for (String stringLotto : stringLottos) {
			this.lottos.add(Lotto.of(stringLotto));
		}
	}

	public void addAutoLotto(final int numberOfLotto) {
		for (int i = 0; i < numberOfLotto; i++) {
			this.lottos.add(Lotto.of(LottoNumber.randomLottoNumber()));
		}
	}

	public LottoResult updateRankCount(WinningLotto winningLotto) {
		LottoResult lottoResult = new LottoResult();
		for (Lotto lotto : this.lottos) {
			Rank rank = winningLotto.calculateRank(lotto);
			lottoResult.addCount(rank);
		}

		return lottoResult;
	}

	public List<Lotto> lottos() {
		return this.lottos;
	}

	public void addAll(List<Lotto> lottoList) {
		lottos.addAll(lottoList);
	}
}
