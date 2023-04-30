package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {

	private final PurchasedLottos purchasedLottos;

	public LottoMachine(long purchaseAmount) {
		this.purchasedLottos = new PurchasedLottos();
		if (purchaseAmount < Lotto.PRICE || purchaseAmount % Lotto.PRICE != 0) {
			throw new IllegalArgumentException("구입 금액이 올바르지 않습니다.");
		}

		long purchaseCount = purchaseAmount / Lotto.PRICE;
		for (long i = 0; i < purchaseCount; i++) {
			this.purchasedLottos.add(new Lotto());
		}
	}

	// TC 작성을 수월하게 하기 위한 생성자, 프로덕션 코드에서 사용금지.
	public LottoMachine(List<Lotto> purchasedLottos) {
		this.purchasedLottos = new PurchasedLottos(purchasedLottos);
	}

	public int purchasedCount() {
		return this.purchasedLottos.size();
	}

	public void calculateScore(WinNumbers winNumbers) {
		this.purchasedLottos.calculateScore(winNumbers);
	}

	public List<PrizeSituation> makePrizeSituations() {
		ScoreBoard scoreBoard = this.purchasedLottos.makeScoreBoard();
		return scoreBoard.makePrizeSituations();
	}

	public List<PrizeSituation> sortInOrderScore(List<PrizeSituation> prizeSituations) {
		return prizeSituations.stream().sorted().collect(Collectors.toList());
	}

	public PurchasedLottos getPurchasedLottos() {
		return this.purchasedLottos;
	}
}
