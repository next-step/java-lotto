package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

	private List<Integer>[] lotto;
	private final RandomGenerator random;

	public Lotto(int pay, RandomGenerator random) {
		this.random = random;
		initLotto(pay);
	}

	private void initLotto(int pay) {
		int numberOfLottos = pay / 1000;
		lotto = new List[numberOfLottos];

		for (int i = 0; i < numberOfLottos; i++) {
			lotto[i] = new ArrayList<>();
			lotto[i].addAll(this.random.generate());
		}
	}

	public int numberOfLottos() {
		return lotto.length;
	}

}
