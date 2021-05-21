package lotto;

import java.util.ArrayList;
import java.util.List;

public class Statistics {

	private final List<Lotto> lottos = new ArrayList<>();
	private final Lotto prizeLotto;

	public Statistics(Lotto prizeLotto) {
		this.prizeLotto = prizeLotto;
	}
	public void addLotto(Lotto lotto) {
		lottos.add(lotto);
	}

	public boolean contains(Lotto lotto) {
		return lottos.contains(lotto);
	}

	public List<Integer> prizeLottoNumbers() {
		return  prizeLotto.numbers();
	}
}
