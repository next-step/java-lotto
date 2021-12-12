package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {

	private static final int MIN_LOTTO_NUMBER = 1;
	private static final int MAX_LOTTO_NUMBER = 45;
	private static final int LOTTO_SIZE = 6;

	private final List<LottoNumber> lottoNumbers;

	private static final List<LottoNumber> allLottoNumbers = new ArrayList<>();

	static {
		IntStream.range(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
			.forEach(i -> allLottoNumbers.add(new LottoNumber(i)));
	}

	private LottoNumbers(List<LottoNumber> lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}

	public static LottoNumbers createManualLottoNumber(List<Integer> autoLottoNumbers) {
		List<LottoNumber> lottoNumbers = new ArrayList<>();
		for (Integer autoLottoNumber : autoLottoNumbers) {
			lottoNumbers.add(new LottoNumber(autoLottoNumber));
		}
		return new LottoNumbers(lottoNumbers);
	}

	public static LottoNumbers createAutoLottoNumber() {
		Collections.shuffle(allLottoNumbers);
		return new LottoNumbers(allLottoNumbers.stream()
			.limit(LOTTO_SIZE)
			.collect(Collectors.toList()));
	}

	public LottoNumbers getSortedLottoNumbers() {
		Collections.sort(this.lottoNumbers);
		return this;
	}

	public List<LottoNumber> lottoNumbers() {
		return lottoNumbers;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoNumbers that = (LottoNumbers)o;
		return Objects.equals(lottoNumbers, that.lottoNumbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumbers);
	}

}
