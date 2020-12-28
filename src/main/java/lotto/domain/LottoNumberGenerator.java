package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoNumberGenerator implements NumberGenerator {
	private static final int LOTTO_SIZE = 6;
	private static final int NUMBER_BOUND = 45;

	private static final Random random = new Random();

	@Override
	public List<LottoNumber> generateNumbers() {
		List<LottoNumber> lotto = new ArrayList<>();
		while (lotto.size() < LOTTO_SIZE) {
			addRandomNumber(lotto);
		}
		Collections.shuffle(lotto);
		return lotto;
	}

	private void addRandomNumber(List<LottoNumber> lotto) {
		LottoNumber randomNumber = LottoNumber.of(random.nextInt(NUMBER_BOUND) + 1);
		if (!lotto.contains(randomNumber)) {
			lotto.add(randomNumber);
		}
	}
}
