package lotto;

import java.util.ArrayList;
import java.util.List;

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

	public List<Lotto> userLottos() {
		return this.lottos;
	}

	private int getBuyLottoCount(int price) {
		return price / Lotto.LOTTO_PRICE;
	}
}
