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
	public List<Integer> generateNumbers() {
		List<Integer> lotto = new ArrayList<>();
		while (lotto.size() < LOTTO_SIZE) {
			addRandomNumber(lotto);
		}
		Collections.shuffle(lotto);
		return lotto;
	}

	private void addRandomNumber(List<Integer> lotto) {
		int randomNumber = random.nextInt(NUMBER_BOUND) + 1;
		if (!lotto.contains(randomNumber)) {
			lotto.add(randomNumber);
		}
	}
}
