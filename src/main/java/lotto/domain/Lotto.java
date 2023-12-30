package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Lotto {
	private final static int LOTTO_SIZE = 6;
	private Set<LottoNumber> lotto;

	public Lotto(final List<LottoNumber> lotto) {
		Set<LottoNumber> uniqueLotto =  Set.copyOf(lotto);

		if (uniqueLotto.size() != LOTTO_SIZE) {
			throw new IllegalArgumentException("로또넘버 개수는 6개여야 합니다.");
		}

		this.lotto = uniqueLotto;
	}

	public Lotto(Integer... numbers) {
		this.lotto = new HashSet<>(6);
		for (Integer number : numbers){
			this.lotto.add(new LottoNumber(number));
		}
	}

	public int contains(final Set<LottoNumber> winningNumbers) {
		int count = 0;
		for (LottoNumber lottoNumber : lotto) {
			for (LottoNumber winningNumber : winningNumbers) {
				if (lottoNumber.equals(winningNumber)) {
					count++;
				}
			}
		}

		return count;
	}

	public Set<LottoNumber> lotto(){
		return lotto;
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
