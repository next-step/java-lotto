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
		int count = winningNumbers.count(lotto);
		if (count == 4) {
			return lotto.checkBonus(bonus);
		}
		return count;
	}

	public List<Lotto> getLottos() {
		return lottos;
	}
}
