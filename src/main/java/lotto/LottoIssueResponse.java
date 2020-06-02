package lotto;

public class LottoIssueResponse {

	private Lottos autoLottos;
	private Lottos manualLottos;

	public LottoIssueResponse(Lottos autoLottos, Lottos manualLottos) {
		this.autoLottos = autoLottos;
		this.manualLottos = manualLottos;
	}

	public int sizeAutoLottos() {
		return autoLottos.size();
	}

	public int sizeManualLottos() {
		return manualLottos.size();
	}

	public int sizeTotal() {
		return autoLottos.size() + manualLottos.size();
	}

	public Lottos getLottos() {
		Lottos lottos = new Lottos();
		lottos.addAll(autoLottos);
		lottos.addAll(manualLottos);
		return lottos;
	}
}
