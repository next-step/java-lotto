package automaticLotto;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Lotto lotto1 = (Lotto)o;
		return Objects.equals(lotto, lotto1.lotto);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lotto);
	}

	@Override
	public String toString() {
		return "Lotto{" +
			"lotto=" + lotto +
			'}';
	}
}
