package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Lotto {
	private final static int LOTTO_SIZE = 6;
	private static final String DELIMITER = ",";
	private final Set<LottoNumber> lotto;

	public Lotto(final String stringLotto) {
		this(toSet(stringLotto));
	}

	private static Set<LottoNumber> toSet(final String stringLotto) {
		Set<LottoNumber> lotto = new HashSet<>();

		String[] stringLottoNumberArray = stringLotto.trim().split(DELIMITER);

		for (String stringLottoNumber : stringLottoNumberArray) {
			lotto.add(new LottoNumber(Integer.parseInt(stringLottoNumber)));
		}

		return lotto;
	}

	public Lotto(final Integer... numbers) {
		this(initLotto(numbers));
	}

	private static Set<LottoNumber> initLotto(final Integer... numbers) {
		Set<LottoNumber> lottoNumbers = new HashSet<>(LOTTO_SIZE);

		for (Integer number : numbers) {
			lottoNumbers.add(new LottoNumber(number));
		}

		return lottoNumbers;
	}

	public Lotto(final Set<LottoNumber> lotto) {
		validate(lotto);
		this.lotto = lotto;
	}

	public void validate(final Set<LottoNumber> lotto) {
		if (!lengthCheck(lotto)) {
			throw new IllegalArgumentException("숫자 6개만 입력해주세요");
		}
	}

	private boolean lengthCheck(final Set<LottoNumber> lotto) {
		return lotto.size() == LOTTO_SIZE;
	}

	public static List<Lotto> initializeEntireLotto(List<String> stringLottos) {
		List<Lotto> entireLotto = new ArrayList<>();

		for (String stringLotto : stringLottos) {
			entireLotto.add(new Lotto(stringLotto));
		}

		return entireLotto;
	}

	public static List<Lotto> lottoFactory(final int numberOfLotto) {
		List<Lotto> entireLotto = new ArrayList<>();

		for (int i = 0; i < numberOfLotto; i++) {
			entireLotto.add(new Lotto(AllLottoNumber.randomLottoNumber()));
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
