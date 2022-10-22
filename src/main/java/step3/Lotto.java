package step3;

import java.util.Set;

public class Lotto {

	private Set<Integer> lotto;

	public Lotto(Set<Integer> lotto) {
		this.lotto = lotto;
	}

	public Set<Integer> getLotto() {
		return lotto;
	}

	public boolean isExist(Integer next) {
		return lotto.contains(next);
	}

	public boolean isBonus(int bonus) {
		return lotto.contains(bonus);
	}
}
