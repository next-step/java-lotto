package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

	public static final int MAX_LOTTO_COUNT = 6;

	private List<LottoNumber> lottoNumbers;

	public Lotto(List<LottoNumber> numbers) {
		validate(numbers);
		this.lottoNumbers = numbers;
	}

	private void validate(List<LottoNumber> numbers) {
		Set<LottoNumber> set = new HashSet<>(numbers);
		if(set.size() != MAX_LOTTO_COUNT) {
			throw new IllegalArgumentException("중복된 숫자가 포함되어 있습니다.");
		}
	}
}
