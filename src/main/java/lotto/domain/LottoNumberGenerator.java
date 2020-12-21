package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoNumberGenerator implements NumberGenerator {
	private final Random random = new Random();

	@Override
	public List<Integer> generateNumbers() {
		List<Integer> lottoNumber = new ArrayList<>();
		while (lottoNumber.size() < 6) {
			addRandomNumber(lottoNumber);
		}
		Collections.shuffle(lottoNumber);
		return lottoNumber;
	}

	private void addRandomNumber(List<Integer> lottoNumber) {
		int randomNumber = random.nextInt(45) + 1;
		if (!lottoNumber.contains(randomNumber)) {
			lottoNumber.add(randomNumber);
		}
	}
}
