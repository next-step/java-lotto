package step4.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
	private final Set<LottoNumber> numbers;

	private static final int LOTTO_NUMBER_LENGTH = 6;
	private static final String LOTTO_PHRASES = "로또 번호는 중복되지 않는 6개의 숫자로 이루어져야 합니다.";

	public Lotto() {
		this.numbers = issueAutoLotto();
		validLotto();
	}

	public Lotto(List<LottoNumber> numbers) {
		this.numbers = new LinkedHashSet<>(numbers);
		validLotto();
	}

	public Set<LottoNumber> issueAutoLotto() {
		List<LottoNumber> lottoValues = LottoNumber.getLottoValues();
		Collections.shuffle(lottoValues);
		lottoValues = lottoValues.stream()
				.limit(LOTTO_NUMBER_LENGTH)
				.sorted()
				.collect(Collectors.toList());
		return new LinkedHashSet<>(lottoValues);
	}

	private void validLotto() {
		if (numbers.size() != LOTTO_NUMBER_LENGTH) {
			throw new IllegalArgumentException(LOTTO_PHRASES);
		}
	}

	public int getMatchCount(List<LottoNumber> lottoNumbers) {
		return (int) numbers.stream()
				.filter(number -> new Lotto(lottoNumbers).containNumber(number))
				.count();
	}

	public boolean containNumber(LottoNumber number) {
		return numbers.contains(number);
	}

	@Override
	public String toString() {
		return Arrays.toString(numbers.toArray());
	}
}
