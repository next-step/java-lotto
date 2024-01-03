package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
	private final static int LOTTO_SIZE = 6;
	private static final String DELIMITER = ",";
	private final Set<LottoNumber> lotto;

	public Lotto(String stringLotto) {
		this(toSet(stringLotto));
	}

	private static Set<LottoNumber> toSet(String stringLotto) {
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

	public Lotto(Set<LottoNumber> lotto) {
		validate(lotto);
		this.lotto = lotto;
	}

	public void validate(Set<LottoNumber> lotto) {
		if (!lengthCheck(lotto)) {
			throw new IllegalArgumentException("숫자 6개 만 입력해주세요");
		}
	}

	private boolean lengthCheck(Set<LottoNumber> lotto) {
		return lotto.size() == LOTTO_SIZE;
	}

	public static List<Lotto> lottoFactory(int numberOfLotto) {
		List<Lotto> allLotto = new ArrayList<>();
		for (int i = 0; i < numberOfLotto; i++) {
			allLotto.add(new Lotto(AllLottoNumber.randomLottoNumber()));
		}
		return allLotto;
	}

	public boolean contains(LottoNumber lottoNumber) {
		return lotto.contains(lottoNumber);
	}

	public Set<LottoNumber> lotto() {
		return lotto;
	}
}
