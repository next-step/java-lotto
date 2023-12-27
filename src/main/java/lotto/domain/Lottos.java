package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public final class Lottos {
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
}
