package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
	public static final int LOTTO_SIZE = 6;
	private final Set<LottoNumber> lottoNumbers;

	public Lotto(Set<LottoNumber> lottoNumbers) {
		validateNumberSize(lottoNumbers);
		this.lottoNumbers = lottoNumbers;
	}

	private void validateNumberSize(Set<LottoNumber> lottoNumbers) {
		if (lottoNumbers.size() != LOTTO_SIZE) {
			throw new IllegalArgumentException("로또는 "+ LOTTO_SIZE + "개 숫자로 생성되어야 합니다. (size=" + lottoNumbers.size() + ")");
		}
	}

	public int size() {
		return lottoNumbers.size();
	}
}
