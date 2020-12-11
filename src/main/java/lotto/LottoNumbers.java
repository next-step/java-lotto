package lotto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumbers {
	private final List<LottoNumber> lottoNumbers;

	public LottoNumbers(List<LottoNumber> lottoNumbers) {
		this.lottoNumbers = lottoNumbers.stream()
			.sorted(LottoNumber::isGraterThanNumber).collect(Collectors.toList());
	}

	public boolean isEqualsNumberOfIndex(int index, LottoNumber lottoNumber) {
		return this.lottoNumbers.get(index).equals(lottoNumber);
	}

	public boolean isContainsLottoNumber(LottoNumber lottoNumber) {
		return this.lottoNumbers.contains(lottoNumber);
	}

	public int isContainsCount(LottoNumbers resultLottoNumbers) {
		return (int) resultLottoNumbers.lottoNumbers.stream().filter(this::isContainsLottoNumber).count();
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
