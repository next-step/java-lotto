package automaticLotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
	private static final int START_POINT = 0;
	private static final List<Integer> candidateNumbers;

	private Lottos boughtLottos;

	static {
		candidateNumbers = new ArrayList<>();

		initiateCandidateNumbers();
	}

	private static void initiateCandidateNumbers() {
		for (int i = Lotto.LOTTO_MINIMUM_NUMBER; i <= Lotto.LOTTO_MAXIMUM_NUMBER; i++) {
			candidateNumbers.add(i);
		}
	}

	public Lottos buy(int budget) {
		int possibleCount = getPossibleCount(budget);
		buyLottos(possibleCount);

		return this.boughtLottos;
	}

	private void buyLottos(int possibleCount) {
		List<Lotto> candidateLottos = new ArrayList<>();

		for (int i = START_POINT; i < possibleCount; i++) {
			candidateLottos.add(new Lotto(getRandomLottoNumbers()));
		}

		this.boughtLottos = new Lottos(candidateLottos);
	}

	private int getPossibleCount(int budget) {
		if (budget < Lotto.LOTTO_PRICE) {
			throw new RuntimeException("you can not buy even one lotto");
		}
		return budget / Lotto.LOTTO_PRICE;
	}

	private List<Integer> getRandomLottoNumbers() {
		Collections.shuffle(candidateNumbers);

		return candidateNumbers.subList(START_POINT, Lotto.LOTTO_LENGTH);
	}
}
