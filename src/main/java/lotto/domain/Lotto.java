package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Lotto {
	private final static int LOTTO_SIZE = 6;
	private final Set<LottoNumber> lotto;

	public Lotto(final List<LottoNumber> lotto) {
		Set<LottoNumber> uniqueLotto = new HashSet<>(lotto);

		if (uniqueLotto.size() != LOTTO_SIZE) {
			throw new IllegalArgumentException("로또넘버 개수는 6개여야 합니다.");
		}

		this.lotto = uniqueLotto;
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

		for (int i = 0; i < LOTTO_SIZE; i++) {
			lottos.add(new LottoNumber(entireLottoNumbers.get(i)));
		}

		return lottos;
	}
}
