package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class PurchasedLottos {

	private final List<Lotto> purchasedLottos;

	public PurchasedLottos() {
		this.purchasedLottos = new ArrayList<>();
	}

	// TC 작성을 수월하게 하기 위한 생성자, 프로덕션 코드에서 사용금지.
	public PurchasedLottos(List<Lotto> lottos) {
		this.purchasedLottos = lottos;
	}

	public void add(Lotto lotto) {
		this.purchasedLottos.add(lotto);
	}

	public void addManualLottos(ManualLottos manualLottos) {
		this.purchasedLottos.addAll(manualLottos.getManualLottos());
	}

	public void calculateScore(WinningNumbers winningNumbers, LottoNumber bonusNumber) {
		for (Lotto lotto : this.purchasedLottos) {
			lotto.calculateScore(winningNumbers, bonusNumber);
		}
	}

	public int size() {
		return this.purchasedLottos.size();
	}

	public List<Lotto> getLottos() {
		return this.purchasedLottos;
	}

	public RankBoard makeRankBoard() {
		return new RankBoard(this.purchasedLottos);
	}
}
