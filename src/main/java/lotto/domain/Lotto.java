package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Lotto {
	private final static int LOTTO_SIZE = 6;
	private static final String DELIMITER = ",";

	private final Set<LottoNumber> lotto;

	public Lotto(final Set<LottoNumber> lotto) {
		validate(lotto);
		this.lotto = lotto;
	}

	public static Lotto of(final String stringLotto) {
		Set<LottoNumber> lotto = new HashSet<>();

		String[] stringLottoNumberArray = stringLotto.trim().split(DELIMITER);

		for (String stringLottoNumber : stringLottoNumberArray) {
			lotto.add(new LottoNumber(Integer.parseInt(stringLottoNumber)));
		}

		return new Lotto(lotto);
	}

	public static Lotto from(final Integer... numbers) {
		Set<LottoNumber> lottoNumbers = new HashSet<>(LOTTO_SIZE);

		for (Integer number : numbers) {
			lottoNumbers.add(new LottoNumber(number));
		}

		return new Lotto(lottoNumbers);
	}

	public void validate(final Set<LottoNumber> lotto) {
		if (!lengthCheck(lotto)) {
			throw new IllegalArgumentException("숫자 6개만 입력해주세요");
		}
	}

	private boolean lengthCheck(final Set<LottoNumber> lotto) {
		return lotto.size() == LOTTO_SIZE;
	}

	public static List<Lotto> initializeEntireLotto(final List<String> stringLottos) {
		List<Lotto> entireLotto = new ArrayList<>();

		for (String stringLotto : stringLottos) {
			entireLotto.add(Lotto.of(stringLotto));
		}

		return entireLotto;
	}

	public static List<Lotto> autoLottoFactory(final int numberOfLotto) {
		List<Lotto> entireLotto = new ArrayList<>();

		for (int i = 0; i < numberOfLotto; i++) {
			entireLotto.add(new Lotto(LottoNumber.randomLottoNumber()));
		}

		return entireLotto;
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
}
