package nextstep.lotto;

import java.util.Set;
import java.util.TreeSet;

public class Lotto {
	private final Set<LottoNumber> numbers;

	public Lotto(final Set<LottoNumber> numbers) {
		if (numbers == null || numbers.size() != 6) {
			throw new IllegalArgumentException("로또 게임은 6개의 로또 넘버로 생성됩니다.");
		}
		this.numbers = new TreeSet<>(numbers) {};
	}

	@Override
	public String toString() {
		return numbers.toString();
	}
}
