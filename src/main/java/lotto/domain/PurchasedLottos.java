package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class PurchasedLottos {

	private final List<Lotto> purchasedLottos;

	public PurchasedLottos() {
		this.purchasedLottos = new ArrayList<>();
	}

	public PurchasedLottos(List<Lotto> lottos) {
		this.purchasedLottos = lottos;
	}

	public void add(Lotto lotto) {
		this.purchasedLottos.add(lotto);
	}

	public int size() {
		return this.purchasedLottos.size();
	}

	public List<Lotto> getLottos() {
		return purchasedLottos;
	}
}
