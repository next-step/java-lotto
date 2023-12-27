package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Lottos {
	private final static int LOTTOS_SIZE = 6;
	private final List<Lotto> lottos;

	public Lottos(final List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public Lotto indexOfLottos(final int index) {
		return lottos.get(index);
	}

	public int contains(final int[] winningNumbers) {
		int count = 0;
		for (Lotto lotto : lottos) {
			for (int winningNumber : winningNumbers) {
				if (lotto.equals(winningNumber)) {
					count++;
				}
			}
		}
		return count;
	}

	public List<String> integers() {
		List<String> result = new ArrayList<>();
		for (Lotto lotto : lottos) {
			result.add(lotto.toString());
		}
		return result;
	}

	public static List<Lotto> generate() {
		List<Lotto> lottos = new ArrayList<>();
		List<Integer> entireLottoNumbers = new ArrayList<>();

		for (int i = 1; i <= 45; i++) {
			entireLottoNumbers.add(i);
		}

		Collections.shuffle(entireLottoNumbers);

		for (int i = 0; i < LOTTOS_SIZE; i++) {
			lottos.add(new Lotto(entireLottoNumbers.get(i)));
		}

		return lottos;
	}
}
