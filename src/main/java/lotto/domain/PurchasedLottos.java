package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

	public void calculateScore(Lotto winningLotto, LottoNumber bonusNumber) {
		for (Lotto lotto : this.purchasedLottos) {
			lotto.calculateScore(winningLotto, bonusNumber);
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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		PurchasedLottos that = (PurchasedLottos)o;
		return Objects.equals(purchasedLottos, that.purchasedLottos);
	}

	@Override
	public int hashCode() {
		return Objects.hash(purchasedLottos);
	}
}
