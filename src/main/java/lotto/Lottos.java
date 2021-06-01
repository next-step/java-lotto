package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
	private final List<Lotto> lottos;

	public Lottos(List<Lotto> lottos) {
		this.lottos = Collections.unmodifiableList(lottos);
	}

	public int count() {
		return lottos.size();
	}

	public Statistics statistics(List<Integer> prizeNumbers, int bonusNumber) {
		WinLotto winLotto = new WinLotto(prizeNumbers, bonusNumber);
		Statistics statistics = new Statistics();
		for (Lotto lotto : lottos) {
			Prize prize = lotto.result(winLotto);
			statistics.addCount(prize);
		}
		return statistics;
	}

	public List<List<Integer>> allNumbers() {
		List<List<Integer>> allNumbers = new ArrayList<>();
		for (Lotto lotto : lottos) {
			allNumbers.add(lotto.numbers());
		}
		return allNumbers;
	}
}
