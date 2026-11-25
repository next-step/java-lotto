package domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
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
		Collections.sort(sorted);
		this.lottoNumbers = sorted;
	}

	public List<LottoNumber> getNumbers() {
		return lottoNumbers;
	}
}
