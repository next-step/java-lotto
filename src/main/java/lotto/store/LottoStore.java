package lotto.store;

import java.util.Objects;

public class LottoStore {

	public LottoStore(int budget, int price) {
		this.budget = budget;
		this.price = price;
	}

	private final int budget;
	private final int price;

	public int count() {
		return budget / price;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof LottoStore))
			return false;
		LottoStore lottoStore = (LottoStore)o;
		return budget == lottoStore.budget && price == lottoStore.price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(budget, price);
	}
}
