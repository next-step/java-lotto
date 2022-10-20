package step2.model;

import java.util.List;
import java.util.Objects;

public class Lotto {

	private List<Integer> lottoSet;

	public Lotto(LottoFactory lottoFactory) {
		this(lottoFactory.getLottoNum());
	}

	public Lotto(List<Integer> lottoSet) {
		this.lottoSet = lottoSet;
	}

	public List<Integer> getLotto() {
		return lottoSet;
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Lotto lotto = (Lotto) o;
		return Objects.equals(lottoSet, lotto.lottoSet);
	}

	public int hashCode() {
		return Objects.hash(lottoSet);
	}
}
