package lotto.domain;

import java.util.Comparator;
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

	public List<RankSituation> makeRankSituations() {
		RankBoard rankBoard = this.purchasedLottos.makeRankBoard();
		return rankBoard.makeRankSituations();
	}

	public PurchasedLottos getPurchasedLottos() {
		return this.purchasedLottos;
	}

	public List<RankSituation> sortInOrderScore(List<RankSituation> rankSituations) {
		return rankSituations.stream()
			.sorted(Comparator.comparing(o -> o.getRank().getWinningMoney())).collect(Collectors.toList());
	}
}
