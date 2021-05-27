package lotto.domain;

import java.util.List;

public class PurchaseLottos {

	private final Lottos manualLottos;
	private final Lottos autoLottos;

	public PurchaseLottos(Lottos manualLottos, Lottos autoLottos) {
		this.manualLottos = manualLottos;
		this.autoLottos = autoLottos;
	}

	public int size() {
		return manualLottos.size() + autoLottos.size();
	}

	public LottoResults findResult(WinningLotto inputWinningLotto) {
		Lottos purchaseLottos = new Lottos();
		purchaseLottos.addLottos(manualLottos);
		purchaseLottos.addLottos(autoLottos);
		return purchaseLottos.findResult(inputWinningLotto);
	}

	public List<Lotto> getManualLottos() {
		return manualLottos.getLottos();
	}

	public List<Lotto> getAutoLottos() {
		return autoLottos.getLottos();
	}

	public int sizeOfManual() {
		return manualLottos.size();
	}

	public int sizeOfAuto() {
		return autoLottos.size();
	}
}
