package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Lotto {
	private final static int LOTTO_SIZE = 6;
	private final Set<LottoNumber> lotto;

	public Lotto(final Set<LottoNumber> lottoNumbers) {
		this.lotto = lottoNumbers;
	}

	public Lotto(final List<LottoNumber> lotto) {
		Set<LottoNumber> uniqueLotto = Set.copyOf(lotto);

		if (uniqueLotto.size() != LOTTO_SIZE) {
			throw new IllegalArgumentException("로또넘버 개수는 6개여야 합니다.");
		}

		this.lotto = uniqueLotto;
	}

	public Lotto(final Integer... numbers) {
		this(initLotto(numbers));
	}

	public int matchCount(final Lotto winningLotto) {
		int count = 0;

		for (LottoNumber winningNumber : winningLotto.lotto) {
			count += matchNumber(winningNumber);
		}

		return count;
	}

	public int matchNumber(final LottoNumber winningNumber) {
		for (LottoNumber lottoNumber : lotto) {
			if (lottoNumber.equals(winningNumber)) {
				return 1;
			}
		}

		return 0;
	}

	private static Set<LottoNumber> initLotto(final Integer... numbers) {
		Set<LottoNumber> lottoNumbers = new HashSet<>(6);

		for (Integer number : numbers) {
			lottoNumbers.add(new LottoNumber(number));
		}

		return lottoNumbers;
	}

	public Set<LottoNumber> lotto() {
		return lotto;
	}

	public List<LottoNumber> generate() {
		List<LottoNumber> lotto = new ArrayList<>();
		List<Integer> entireLottoNumbers = new ArrayList<>();

		for (int i = 1; i <= 45; i++) {
			entireLottoNumbers.add(i);
		}

		Collections.shuffle(entireLottoNumbers);

		for (int i = 0; i < LOTTO_SIZE; i++) {
			lotto.add(new LottoNumber(entireLottoNumbers.get(i)));
		}

		return lotto;
	}
}
