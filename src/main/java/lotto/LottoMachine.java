package lotto;

import java.util.ArrayList;
import java.util.List;

import lotto.utils.RandomUtils;

public class LottoMachine {

	private final List<Lotto> lottos;

	public LottoMachine(int buyCount) {
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
