package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottoGenerator {
	private final static int LOTTOS_SIZE = 6;

	public static List<Lotto> generate() {
		Lottos lottos = new Lottos();
		List<Lotto> shuffledLottos = lottos.allLottoNumbers().shuffle();
		List<Lotto> extractedLottos = new ArrayList<>(LOTTOS_SIZE);

		for (int i = 0; i < LOTTOS_SIZE; i++) {
			extractedLottos.add(shuffledLottos.get(i));
		}

		return extractedLottos;
	}
}
