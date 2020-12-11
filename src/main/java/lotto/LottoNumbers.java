package lotto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumbers {
	public static final int MAX_NUMBERS_SIZE = 6;
	private final List<LottoNumber> lottoNumbers;

	public LottoNumbers(List<LottoNumber> lottoNumbers) {
		verifyNumbersSize(lottoNumbers.size());
		this.lottoNumbers = lottoNumbers.stream()
			.sorted(LottoNumber::isGraterThanNumber).collect(Collectors.toList());
	}

	private void verifyNumbersSize(int size) {
		if (size > MAX_NUMBERS_SIZE) {
			throw new IllegalArgumentException("로또 숫자는 6을 초과할수 없습니다.");
		}
	}

	public boolean isEqualsNumberOfIndex(int index, LottoNumber lottoNumber) {
		return this.lottoNumbers.get(index).equals(lottoNumber);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LottoNumbers that = (LottoNumbers) o;

		for (LottoNumber element : that.lottoNumbers) {
			if (!this.lottoNumbers.contains(element)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumbers);
	}
}
