package generate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static domain.Lotto.LOTTO_MAX_NUMBER;

public class DefaultLottoRandomNumberGenerator implements LottoRandomNumberGenerator {
	public DefaultLottoRandomNumberGenerator() {
	}

	public List<Integer> randomNumber(Integer length) {
		List<Integer> randoms = new ArrayList<>();

		for (int i = 0; i < length; i++) {
			Random random = new Random();
			int newRandomNumber = random.nextInt(LOTTO_MAX_NUMBER) + 1;

			if (!isDuplicate(randoms, newRandomNumber)) {
				randoms.add(newRandomNumber);
			} else {
				--i;
			}
		}

		return randoms;
	}

	private Boolean isDuplicate(List<Integer> randoms, int aRandomNumber) {
		if (randoms.contains(aRandomNumber)) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
}
