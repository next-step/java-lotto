package domain.lotto;

import static java.util.Collections.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Lotto {

	private final List<LottoNumber> lottoNumbers;

	private static final int LOTTO_SIZE = 6;

	public Lotto(List<LottoNumber> lottoNumbers) {
		if (lottoNumbers.size() != LOTTO_SIZE) {
			throw new IllegalArgumentException("로또 번호는 6개입니다");
		}
		if (new HashSet<>(lottoNumbers).size() != LOTTO_SIZE) {
			throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다");
		}

		List<LottoNumber> sorted = new ArrayList<>(lottoNumbers);
		sort(sorted);
		this.lottoNumbers = sorted;
	}

	public List<LottoNumber> getNumbers() {
		return lottoNumbers;
	}

	public int countMatch(Lotto other) {
		int count = 0;
		for (LottoNumber number : lottoNumbers) {
			count += other.matchScore(number);
		}
		return count;
	}

	private int matchScore(LottoNumber number) {
		if (contains(number)) {
			return 1;
		}
		return 0;
	}

	private boolean contains(LottoNumber number) {
		return lottoNumbers.contains(number);
	}

}
