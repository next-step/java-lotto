package lotto.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class Lotto {
	private final static int LOTTO_SIZE = 6;
	private static final String DELIMITER = ",";

	private final Set<LottoNumber> lotto;

	private Lotto(final Set<LottoNumber> lotto) {
		validate(lotto);
		this.lotto = lotto;
	}

	public static Lotto of(final Set<LottoNumber> lotto) {
		validate(lotto);

		return new Lotto(lotto);
	}

	private static void validate(final Set<LottoNumber> lotto) {
		if (!lengthCheck(lotto)) {
			throw new IllegalArgumentException("숫자 6개만 입력해주세요");
		}
	}

	private static boolean lengthCheck(final Set<LottoNumber> lotto) {
		return lotto.size() == LOTTO_SIZE;
	}

	public static Lotto of(final String stringLotto) {
		Set<LottoNumber> lotto = new HashSet<>();

		String[] stringLottoNumberArray = stringLotto.split(DELIMITER);

		for (String stringLottoNumber : stringLottoNumberArray) {
			lotto.add(LottoNumber.of(Integer.parseInt(stringLottoNumber.trim())));
		}

		return new Lotto(lotto);
	}

	public static Lotto from(final Integer... numbers) {
		Set<LottoNumber> lottoNumbers = new HashSet<>(LOTTO_SIZE);

		for (Integer number : numbers) {
			lottoNumbers.add(LottoNumber.of(number));
		}

		return new Lotto(lottoNumbers);
	}

	public boolean contains(final LottoNumber lottoNumber) {
		return lotto.contains(lottoNumber);
	}

	public Set<LottoNumber> lotto() {
		return lotto;
	}

	public int countMatchingNumber(final Lotto winningNumbers) {
		int count = 0;

		for (LottoNumber lottoNumber : lotto) {
			if (winningNumbers.contains(lottoNumber)) {
				count++;
			}
		}

		return count;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Lotto lotto1 = (Lotto)o;
		return Objects.equals(lotto, lotto1.lotto);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lotto);
	}
}
