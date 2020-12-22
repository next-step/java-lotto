package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
	private List<Integer> lotto;

	public Lotto(List<Integer> lotto) {
		this.lotto = lotto;
		if (lotto == null) {
			this.lotto = new ArrayList<>();
		}
	}

	public List<Integer> getLotto() {
		return lotto;
	}

	private int match(Lotto winLotto) {
		return (int) lotto.stream()
			.filter(lotto -> winLotto.lotto.contains(lotto))
			.count();
	}

	public LottoRank rankLotto(Lotto winLottoNumber) {
		int sameNumberCount = match(winLottoNumber);
		return LottoRank.valueOfCount(sameNumberCount);
	}

	@Override
	public String toString() {
		return "["+lotto.stream().map(lotto -> Integer.toString(lotto)).collect(Collectors.joining(", "))+"]";
	}
}
