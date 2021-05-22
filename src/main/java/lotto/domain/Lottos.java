package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

	private List<Lotto> lottos;

	public Lottos() {
		this.lottos = new ArrayList<>();
	}

	public int getSize() {
		return this.lottos.size();
	}

	public void addLotto(Lotto lotto) {
		this.lottos.add(lotto);
	}

	public LottoResult getLottoResult(Lotto winningLotto) {
		List<LottoRank> userLottoRanks = new ArrayList<>();
		for (Lotto lotto : this.lottos) {
			userLottoRanks.add(LottoRank.valueOf(winningLotto.getMatchesCount(lotto)));
		}
		return new LottoResult(userLottoRanks);
	}

	@Override
	public String toString() {
		String lottosToString = "";
		for (Lotto lotto : this.lottos) {
			lottosToString += lotto.toString() + "\n";
		}
		return lottosToString;
	}

}
