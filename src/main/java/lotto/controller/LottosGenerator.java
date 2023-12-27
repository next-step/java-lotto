package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import lotto.domain.Lotto;

public class LottosGenerator {
	private final static int LOTTOS_SIZE = 6;

	public static List<Lotto> generate(){
		List<Lotto> lottos = new ArrayList<>();
		List<Integer> entireLottoNumbers = new ArrayList<>(
			Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
				11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
				21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
				31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
				41, 42, 43, 44, 45));

		Collections.shuffle(entireLottoNumbers);

		for (int i = 0; i < LOTTOS_SIZE; i++) {
			lottos.add(new Lotto(entireLottoNumbers.get(i)));
		}

		return lottos;
	}
}
