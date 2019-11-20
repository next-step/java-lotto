package step3.model;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
	private static final int LOTTO_NUMBER_COUNT = 6;

	private final Set<LottoNumber> lotto;

	private Lotto(Set<LottoNumber> lotto) {
		if (lotto.size() != LOTTO_NUMBER_COUNT) {
			throw new IllegalArgumentException();
		}
		this.lotto = lotto;
	}

	public static Lotto of(List<Integer> numbers) {
		Set<LottoNumber> lotto = new LinkedHashSet<>();
		for (Integer number : numbers) {
			lotto.add(LottoNumber.of(number));
		}
		return new Lotto(lotto);
	}

	public static Lotto ofComma(String value) {
		return new Lotto(Arrays.stream(value.split(","))
				.map(LottoNumber::of)
				.collect(Collectors.toSet()));
	}

	public int getMatchCount(Lotto target) {
		int count = 0;
		for (LottoNumber lottoNumber : lotto) {
			count += target.hasNumber(lottoNumber) ? 1 : 0;
		}
		return count;
	}

	public Rank getRank(Lotto taret, LottoNumber bonusNumber) {
		return Rank.valueOf(getMatchCount(taret), hasNumber(bonusNumber));
	}

	boolean hasNumber(LottoNumber lottoNumber) {
		return lotto.contains(lottoNumber);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Lotto lotto1 = (Lotto) o;
		return Objects.equals(lotto, lotto1.lotto);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lotto);
	}

	@Override
	public String toString() {
		return this.lotto.toString();
	}
}
