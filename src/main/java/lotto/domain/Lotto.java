package lotto.domain;

import java.util.List;
import java.util.Objects;

import lotto.enums.Rank;

public class Lotto {

	private final List<Integer> lottoNumbers;

	public Lotto(List<Integer> lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}

	public Rank figureOutRank(Lotto winningLotto) {
		long matchNumberCount = lottoNumbers.stream()
										.filter(winningLotto.lottoNumbers::contains)
										.count();
		return Rank.of(matchNumberCount);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Lotto lotto = (Lotto)o;
		return lottoNumbers.equals(lotto.lottoNumbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumbers);
	}
}
