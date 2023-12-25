package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public final class LottoGenerator {
	private final static int LOTTOS_SIZE = 6;

	public static List<Lottos> generate(final int number) {
		List<Lottos> entireLottos = new ArrayList<>();
		for (int i = 0; i < number; i++) {
			entireLottos.add(new Lottos().allLottoNumbers());
		}

		return shuffle(number, entireLottos);
	}

	private static List<Lottos> shuffle(final int number, final List<Lottos> entireLottos) {
		List<Lottos> extractedLottos = new ArrayList<>();
		for (int i = 0; i < number; i++) {
			List<Lotto> shuffledLottos = entireLottos.get(i).shuffle();
			extractedLottos = extract(entireLottos, shuffledLottos, i);
		}

		return extractedLottos;
	}

	private static List<Lottos> extract(final List<Lottos> entireLottos, final List<Lotto> shuffledLottos, int i) {
		List<Lotto> extractedLottos = new ArrayList<>(LOTTOS_SIZE);

		for (int j = 0; j < LOTTOS_SIZE; j++) {
			extractedLottos.add(shuffledLottos.get(j));
		}
		entireLottos.set(i, new Lottos(extractedLottos));

		return entireLottos;
	}
}
