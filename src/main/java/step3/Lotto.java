package step3;

import java.util.Set;
import java.util.TreeSet;

public class Lotto {
	private static final int LOTTO_START = 1;
	private static final int LOTTO_END = 45;

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
			lotto.add(checkInt(input));
		}
		return lotto;
	}

	private static Integer checkInt(String input) {
		int change = Integer.parseInt(input);
		if (change < LOTTO_START || LOTTO_END < change) {
			throw new IllegalArgumentException(LOTTO_START + " ~ " + LOTTO_END + " 중복되지 않는 수를 입력해주세요");
		}
		return change;
	}

	public int checkBonus(int bonus) {
		if (lotto.contains(bonus)) {
			return 1;
		}
		return count(this);
	}

	public int count(Lotto guestLotto) {
		int count = 0;
		for (Integer number : guestLotto.getLotto()) {
			if (isExist(number)) {
				count++;
			}
		}
		return count;
	}

	public boolean isExist(Integer lottoNumber) {
		return lotto.contains(lottoNumber);
	}

	public Set<Integer> getLotto() {
		return lotto;
	}
}
