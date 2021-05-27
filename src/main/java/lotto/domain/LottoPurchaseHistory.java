package lotto.domain;

public class LottoPurchaseHistory {

	private Lottos autoLottos;
	private Lottos manualLottos;

	public int getAutoLottoCount() {
		return this.autoLottos.getSize();
	}

	public int getManualLottoCount() {
		return this.manualLottos.getSize();
	}

	public void setAutoLottos(Lottos autoLottos) {
		this.autoLottos = autoLottos;
	}

	public void setManualLottos(Lottos manualLottos) {
		this.manualLottos = manualLottos;
	}
}
