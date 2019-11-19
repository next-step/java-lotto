package step2;

import step2.model.AutoLotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
	private static final int LOTTO_PRICE = 1000;
	List<AutoLotto> lottos = new ArrayList<>();

	public LottoGame(int money) {
		if (money < LOTTO_PRICE) {
			throw new IllegalArgumentException();
		}
		for (int i = 0, iLen = money / LOTTO_PRICE; i < iLen; i++) {
			lottos.add(new AutoLotto());
		}
	}

	public LottoGame(List<AutoLotto> lottos) {
		this.lottos = lottos;
	}

	public List<AutoLotto> getLottos() {
		return this.lottos;
	}

	public long getPrizeSum(String winLotto) {
		long prizeSum = 0;
		for (AutoLotto lotto : lottos) {
			prizeSum += lotto.getRank(winLotto).getPrize();
		}
		return prizeSum;
	}
}
