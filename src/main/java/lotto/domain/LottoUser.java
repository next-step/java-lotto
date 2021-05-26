package lotto.domain;

import lotto.utils.LottoGenerator;

public class LottoUser {

	private Lottos lottos;

	public LottoUser() {
		this.lottos = new Lottos();
	}

	public LottoPurchaseHistory buyLottos(Lottos manualLottos, int money) {
		this.lottos.addAllLottos(manualLottos);
		int autoLottoCount = getAutoLottoCount(money, manualLottos.getSize());
		buyGenerateLottos(autoLottoCount);
		return new LottoPurchaseHistory(new LottoCount(autoLottoCount), new LottoCount(manualLottos.getSize()));
	}

	private void buyGenerateLottos(int autoLottoCount) {
		int count = 0;
		while (count < autoLottoCount) {
			this.lottos.addLotto(LottoGenerator.generate());
			count++;
		}
	}

	private int getAutoLottoCount(int money, int manualLottoCount) {
		return money / Lotto.LOTTO_PRICE - manualLottoCount;
	}

	public int getLottoCount() {
		return this.lottos.getSize();
	}

	public LottoResult getUserLottoResult(Lotto winningLotto, LottoNumber bonusNumber) {
		return this.lottos.getLottoResult(winningLotto, bonusNumber);
	}

	public Lottos getUserLottos() {
		return this.lottos;
	}

}
