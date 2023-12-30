package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Lotto {
	private final static int LOTTOS_SIZE = 6;
	private final List<LottoNumber> lotto;

	public Lotto(final List<LottoNumber> lotto) {
		this.lotto = lotto;
	}

	public LottoNumber indexOfLotto(final int index) {
		return lotto.get(index);
	}

	public int contains(final int[] winningNumbers) {
		int count = 0;
		for (LottoNumber lottoNumber : lotto) {
			for (int winningNumber : winningNumbers) {
				if (lottoNumber.equals(winningNumber)) {
					count++;
				}
			}
		}

		return count;
	}

	public List<String> integers() {
		List<String> result = new ArrayList<>();
		for (LottoNumber lottoNumber : lotto) {
			result.add(lottoNumber.toString());
		}

		return result;
	}

	public static List<LottoNumber> generate() {
		List<LottoNumber> lottos = new ArrayList<>();
		List<Integer> entireLottoNumbers = new ArrayList<>();

		for (int i = 1; i <= 45; i++) {
			entireLottoNumbers.add(i);
		}

		Collections.shuffle(entireLottoNumbers);

		for (int i = 0; i < LOTTOS_SIZE; i++) {
			lottos.add(new LottoNumber(entireLottoNumbers.get(i)));
		}

		return lottos;
	}
}
