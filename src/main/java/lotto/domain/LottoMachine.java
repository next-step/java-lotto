package lotto.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {

	private final PurchasedLottos purchasedLottos;
	private final long autoCount;

	public LottoMachine(long purchaseAmount) {
		this(purchaseAmount, new ManualLottos());
	}

	public LottoMachine(long purchaseAmount, ManualLottos manualLottos) {
		if (purchaseAmount < Lotto.PRICE) {
			throw new IllegalArgumentException("구입 금액이 올바르지 않습니다.");
		}

		this.purchasedLottos = new PurchasedLottos();
		long totalCount = purchaseAmount / Lotto.PRICE;
		this.autoCount = totalCount - manualLottos.size();

		this.purchasedLottos.addManualLottos(manualLottos);
		for (long l = 0; l < autoCount; l++) {
			this.purchasedLottos.add(new Lotto());
		}
	}

	// TC 작성을 수월하게 하기 위한 생성자, 프로덕션 코드에서 사용금지.
	public LottoMachine(List<Lotto> purchasedLottos) {
		this.purchasedLottos = new PurchasedLottos(purchasedLottos);
		this.autoCount = 0;
	}

	public int purchasedCount() {
		return this.purchasedLottos.size();
	}

	public List<RankSituation> makeRankSituations() {
		RankBoard rankBoard = this.purchasedLottos.makeRankBoard();
		return rankBoard.makeRankSituations();
	}

	public List<RankSituation> sortInOrderScore(List<RankSituation> rankSituations) {
		return rankSituations.stream()
			.sorted(Comparator.comparing(o -> o.getRank().getWinningMoney())).collect(Collectors.toList());
	}

	public PurchasedLottos getPurchasedLottos() {
		return this.purchasedLottos;
	}

	public long getAutoCount() {
		return this.autoCount;
	}
}
