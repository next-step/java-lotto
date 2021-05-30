package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoShop {
	private static final int START_POINT = 0;
	private static final List<Integer> candidateNumbers;

	static {
		candidateNumbers = new ArrayList<>();

		initiateCandidateNumbers();
	}

	private static void initiateCandidateNumbers() {
		for (int i = LottoNumber.LOTTO_MINIMUM_NUMBER; i <= LottoNumber.LOTTO_MAXIMUM_NUMBER; i++) {
			candidateNumbers.add(i);
		}
	}

	public static Lottos buy(Budget budget) {
		return buy(budget, Lottos.EMPTY_LOTTOS);
	}

	public static Lottos buy(Budget budget, List<Lotto> manualLottos) {
		List<Lotto> candidateLottos = new ArrayList<>();

		int possibleCount = budget.getPossibleCount(manualLottos);
		for (int i = START_POINT; i < possibleCount; i++) {
			candidateLottos.add(new Lotto(getRandomLottoNumbers()));
		}

		return new Lottos(candidateLottos, manualLottos);
	}

	private static List<Integer> getRandomLottoNumbers() {
		Collections.shuffle(candidateNumbers);

		return new ArrayList<>(candidateNumbers.subList(START_POINT, Lotto.LOTTO_LENGTH));
	}
}
