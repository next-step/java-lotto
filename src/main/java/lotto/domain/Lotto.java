package lotto.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
	public static final int LOTTO_SIZE = 6;
	public static final Amount LOTTO_PRICE = new Amount(1_000);
	public static final String SPLIT_DELIMITER = ",";
	private final Set<LottoNumber> lottoNumbers;

	public Lotto() {
		lottoNumbers = new HashSet<>(LottoRandomGenerator.generate(LOTTO_SIZE));
		validateNumberSize(lottoNumbers);
	}

	public Lotto(String lottoNumbersInput) {
		Set<LottoNumber> lottoNumbers = Stream.of(lottoNumbersInput.split(SPLIT_DELIMITER))
			.map(LottoNumber::new)
			.collect(Collectors.toSet());

		validateNumberSize(lottoNumbers);
		this.lottoNumbers = lottoNumbers;
	}

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

	@Override
	public String toString() {
		return lottoNumbers.toString();
	}

	public boolean contain(LottoNumber number) {
		return lottoNumbers.contains(number);
	}
}
