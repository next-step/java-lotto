package lotto.domain;

import lotto.utils.LottoGenerator;

public class LottoUser {

	private Lottos lottos;
	private long price;

	public LottoUser(long price) {
		this.lottos = new Lottos();
		this.price = price;
	}

	// todo test
	public void buyGenerateLottos() {
		int count = 0;
		while (count < getBuyAutoLottoCount()) {
			this.lottos.addLotto(LottoGenerator.generate());
			count++;
		}
	}

	// todo test
	public void buyManualLottos(Lottos manualLottos) {
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

	private long getBuyLottoCount() {
		return this.price / Lotto.LOTTO_PRICE;
	}

	private long getBuyAutoLottoCount() {
		return getBuyLottoCount() - getLottoCount();
	}

}
