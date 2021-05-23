package automaticLotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
	private Set<Integer> lotto;

	public Lotto(List<Integer> randomNumberList) {
		this.lotto = new HashSet<>(randomNumberList);
		validateRandomNumberListSize(this.lotto);
	}

	private void validateRandomNumberListSize(Set<Integer> lotto) {
		if (lotto.size() != 6) {
			throw new RuntimeException("lotto numbers must be consist of six numbers");
		}
	}

}
