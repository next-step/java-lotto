package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public final class LottoNumber {
	private static final Integer MIN_LOTTO_NUMBER = 1;
	private static final Integer MAX_LOTTO_NUMBER = 45;
	private static final int LOTTO_SIZE = 6;

	private static final List<LottoNumber> CACHE = new ArrayList<>();

	private final Integer lottoNumber;

	static {
		for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
			CACHE.add(new LottoNumber(i));
		}
	}

	private LottoNumber(final Integer lottoNumber) {
		this.lottoNumber = lottoNumber;
	}

	public static LottoNumber of(final Integer lottoNumber) {
		validate(lottoNumber);
		return CACHE.get(lottoNumber - 1);
	}

	private static void validate(final Integer lottoNumber) {
		if (lottoNumber >= MIN_LOTTO_NUMBER && lottoNumber <= MAX_LOTTO_NUMBER) {
			return;
		}

		throw new IllegalArgumentException("1과 45 사이의 숫자를 입력해주세요.");
	}

	public static Set<LottoNumber> randomLottoNumber() {
		Collections.shuffle(CACHE);

		return new HashSet<>(CACHE.subList(0, LOTTO_SIZE));
	}

	@Override
	public boolean equals(final Object o) {
		if (this.lottoNumber == o)
			return true;
		if (o == null)
			return false;
		LottoNumber lotto1 = (LottoNumber)o;

		return Objects.equals(lottoNumber, lotto1.lottoNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumber);
	}

	@Override
	public String toString() {
		return Integer.toString(lottoNumber);
	}
}
