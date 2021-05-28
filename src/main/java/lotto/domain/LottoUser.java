package lotto.domain;

import lotto.utils.LottoGenerator;

public class LottoUser {

	private Lottos lottos;
	private LottoPurchaseHistory lottoPurchaseHistory;

	public LottoUser() {
		this.lottos = new Lottos();
		this.lottoPurchaseHistory = new LottoPurchaseHistory();
	}

	public void buyLottos(Lottos manualLottos, int money) {
		this.lottos.addAllLottos(manualLottos);
		this.lottoPurchaseHistory.setManualLottos(manualLottos);
		int autoLottoCount = getAutoLottoCount(money, manualLottos.getSize());
		buyGenerateLottos(autoLottoCount);
	}

	private void buyGenerateLottos(int autoLottoCount) {
		Lottos autoLottos = new Lottos();
		int count = 0;
		while (count < autoLottoCount) {
			autoLottos.addLotto(LottoGenerator.generate());
			count++;
		}
		this.lottoPurchaseHistory.setAutoLottos(autoLottos);
		this.lottos.addAllLottos(autoLottos);
	}

	public LottoPurchaseHistory getLottoPurchaseHistory() {
		return this.lottoPurchaseHistory;
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
