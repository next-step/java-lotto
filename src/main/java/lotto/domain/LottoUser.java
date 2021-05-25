package lotto.domain;

import lotto.utils.LottoGenerator;

public class LottoUser {

	private Lottos lottos;
	private int price;
	private int manualLottoCount;
	private int autoLottoCount;

	public LottoUser(int price) {
		this.lottos = new Lottos();
		this.price = price;
	}

	public void buyGenerateLottos() {
		int count = 0;
		while (count < getAutoLottoCount()) {
			this.lottos.addLotto(LottoGenerator.generate());
			count++;
		}
	}

	public void buyManualLottos(Lottos manualLottos) {
		this.manualLottoCount = manualLottos.getSize();
		this.lottos.addAllLottos(manualLottos);
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

	public int getAutoLottoCount() {
		this.autoLottoCount = getBuyLottoCount() - this.manualLottoCount;
		return this.autoLottoCount;
	}

	public int getManualLottoCount() {
		return this.manualLottoCount;
	}

	public int getBuyLottoCount() {
		return this.price / Lotto.LOTTO_PRICE;
	}

}
