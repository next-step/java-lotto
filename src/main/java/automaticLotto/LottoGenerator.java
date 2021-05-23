package automaticLotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
	Lottos boughtLottos;
	final List<Integer> candidateNumbers;

	public LottoGenerator() {
		candidateNumbers = new ArrayList<>();

		initiateCandidateNumbers();
	}

	private void initiateCandidateNumbers() {
		for (int i = 1; i <= 45; i++) {
			candidateNumbers.add(i);
		}
	}

	public Lottos buy(int budget) {
		int possibleCount = getPossibleCount(budget);
		publishLottos(possibleCount);

		return this.boughtLottos;
	}

	private void publishLottos(int possibleCount) {
		List<Lotto> candidateLottos = new ArrayList<>();

		for (int i = 0; i < possibleCount; i++) {
			candidateLottos.add(new Lotto(getRandomLottoNumbers()));
		}

		this.boughtLottos = new Lottos(candidateLottos);
	}

	private int getPossibleCount(int budget) {
		if (budget < 1000) {
			throw new RuntimeException("you can not buy even one lotto");
		}
		return budget / 1000;
	}

	private List<Integer> getRandomLottoNumbers() {
		Collections.shuffle(candidateNumbers);

		return candidateNumbers.subList(0, 6);
	}
}
