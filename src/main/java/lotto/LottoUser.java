package lotto;

import java.util.ArrayList;
import java.util.List;

import lotto.rank.LottoRank;

public class LottoUser {

	private final List<Lotto> lottos;

	public LottoUser() {
		this.lottos = new ArrayList<>();
	}

	public void buyLottos(final int price) {
		int count = 0;
		while (count < getBuyLottoCount(price)) {
			this.lottos.add(LottoGenerator.generate());
			count++;
		}
	}

	public int lottoCount() {
		return this.lottos.size();
	}

	public LottoResult lottoResult(Lotto winningLotto) {
		List<LottoRank> userLottoRanks = new ArrayList<>();
		for (Lotto lotto : this.lottos) {
			userLottoRanks.add(LottoScratcher.scratchLotto(winningLotto.matchesCount(lotto)));
		}
		return new LottoResult(userLottoRanks);
	}

	private int getBuyLottoCount(int price) {
		return price / Lotto.LOTTO_PRICE;
	}

}
