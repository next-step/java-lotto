package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import lotto.enums.Rank;

public class Lotto {

	private static final int LOTTO_NUMBERS_LENGTH = 6;

	private final List<Integer> lottoNumbers;

	public Lotto(List<Integer> lottoNumbers) {
		if (lottoNumbers.size() != LOTTO_NUMBERS_LENGTH) {
			throw new IllegalArgumentException("로또 번호는 " + LOTTO_NUMBERS_LENGTH + "개의 숫자여야 합니다.");
		}

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

	@Override
	public String toString() {
		return lottoNumbers.stream()
						.map(Object::toString)
						.collect(Collectors.joining(", "));
	}
}
