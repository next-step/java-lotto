package lotto;

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

	public Statistics statistics(List<Integer> prizeNumbers) {
		Lotto prizeLotto = new Lotto(prizeNumbers);
		Statistics statistics = new Statistics();
		for (Lotto lotto : lottos) {
			Prize prize = lotto.match(prizeLotto);
			statistics.addCount(prize);
		}
		return statistics;
	}
}
