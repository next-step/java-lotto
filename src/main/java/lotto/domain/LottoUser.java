package lotto.domain;

import lotto.utils.LottoGenerator;

public class LottoUser {

	private Lottos lottos;

	public LottoUser() {
		lottos = new Lottos();
	}

	public void buyGenerateLottos(final int price) {
		int count = 0;
		while (count < getBuyLottoCount(price)) {
			this.lottos.addLotto(LottoGenerator.generate());
			count++;
		}
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

	private int getBuyLottoCount(int price) {
		return price / Lotto.LOTTO_PRICE;
	}

}
