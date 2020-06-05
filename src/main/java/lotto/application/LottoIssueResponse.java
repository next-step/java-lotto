package lotto.application;

import lotto.domain.Lottos;

public class LottoIssueResponse {

	private Lottos lottos;
	private int sizeAutoLottos;
	private int sizeManualLottos;

	public LottoIssueResponse(Lottos autoLottos, Lottos manualLottos) {
		this.sizeAutoLottos = autoLottos.size();
		this.sizeManualLottos = manualLottos.size();

		Lottos lottos = new Lottos();
		lottos.addAll(autoLottos);
		lottos.addAll(manualLottos);
		this.lottos = lottos;
	}

	public Lottos getLottos() {
		return lottos;
	}

	public int sizeAutoLottos() {
		return sizeAutoLottos;
	}

	public int sizeManualLottos() {
		return sizeManualLottos;
	}

	public int sizeTotal() {
		return sizeAutoLottos() + sizeManualLottos();
	}
}
