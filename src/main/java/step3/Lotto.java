package step3;

import java.util.Set;
import java.util.TreeSet;

public class Lotto {

	private Set<Integer> lotto;

	public Lotto(Set<Integer> lotto) {
		this.lotto = lotto;
	}

	public Lotto(String[] inputs) {
		this.lotto = new TreeSet<>();
		for (String input : inputs) {
			this.lotto.add(Integer.parseInt(input));
		}
	}

	public Set<Integer> getLotto() {
		return lotto;
	}

	public boolean isExist(Integer next) {
		return lotto.contains(next);
	}
}
