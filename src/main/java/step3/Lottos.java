package step3;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Lottos {

	private final List<Lotto> lottos;

	public Lottos(List<Lotto> lotto) {
		this.lottos = lotto;
	}

	public int results(Lotto lotto, Lotto winningNumbers, int bonus) {
		int count = 0;
		Iterator<Integer> itr = winningNumbers.getLotto().iterator();
		while (itr.hasNext()) {
			count = checkContains(lotto, count, itr);
		}
		if (count == 4) {
			return checkBonus(lotto, count, bonus);
		}
		return count;
	}

	private int checkBonus(Lotto lotto, int count, int bonus) {
		if (lotto.isExist(bonus)) {
			return count + 3;
		}
		return count;
	}

	private int checkContains(Lotto guestLotto, int count, Iterator<Integer> itr) {
		if (guestLotto.isExist(itr.next())) {
			count++;
		}
		return count;
	}

	public List<Lotto> getLottos() {
		return lottos;
	}
}
