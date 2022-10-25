package step3;

import java.util.Set;
import java.util.TreeSet;

public class Lotto {

	private Set<Integer> lotto;

	public Lotto(Set<Integer> lotto) {
		this.lotto = lotto;
	}

	public Lotto(String[] inputs) {
		this(makeLotto(inputs));
	}

	private static Set<Integer> makeLotto(String[] inputs) {
		Set<Integer> lotto = new TreeSet<>();
		for (String input : inputs) {
			lotto.add(Integer.parseInt(input));
		}
		return lotto;
	}

	public Set<Integer> getLotto() {
		return lotto;
	}

	public boolean isExist(Integer next) {
		return lotto.contains(next);
	}
}
