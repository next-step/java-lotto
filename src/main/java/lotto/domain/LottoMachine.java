package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.utils.RandomUtils;

public class LottoMachine {

	private final List<Lotto> lottos;

	public LottoMachine(int buyAmount) {
		if (buyAmount < Lotto.LOTTO_PRICE || buyAmount % Lotto.LOTTO_PRICE != 0) {
			throw new IllegalArgumentException("구입 금액이 올바르지 않습니다.");
		}

		int buyCount = buyAmount / Lotto.LOTTO_PRICE;

		this.lottos = new ArrayList<>();
		for (int i = 0; i < buyCount; i++) {
			this.lottos.add(new Lotto());
		}
	}

	public void selectLottoNumbers() {
		for (Lotto lotto : this.lottos) {
			this.fillEachLotto(lotto);
		}
	}

	private void fillEachLotto(Lotto lotto) {
		while (lotto.selectedNumbersSize() < Lotto.LOTTO_SIZE) {
			lotto.selectLottoNumbers(RandomUtils.randomInt());
		}
	}

	public int lottosSize() {
		return this.lottos.size();
	}
}
