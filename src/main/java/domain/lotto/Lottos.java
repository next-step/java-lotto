package domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

	private final List<Lotto> lottos;

	private static final int LOTTO_PRICE = 1000;

	public Lottos(int money) {
		this(buy(money));
	}

	public Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	private static List<Lotto> buy(int money) {
		List<Lotto> lottos = new ArrayList<>();
		int lottoCount = money / LOTTO_PRICE;
		LottoGenerator lottoGenerator = new LottoGenerator();
		for (int i = 0; i < lottoCount; i++) {
			lottos.add(lottoGenerator.generate());
		}
		return lottos;
	}

	public List<Lotto> getLottos() {
		return lottos;
	}

	public LottoResult result(WinningLotto winningLotto) {
		List<Rank> ranks = new ArrayList<>();
		for (Lotto lotto : lottos) {
			ranks.add(winningLotto.rank(lotto));
		}
		return new LottoResult(ranks);
	}
}
