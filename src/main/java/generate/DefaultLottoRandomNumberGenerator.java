package generate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static domain.Lotto.LOTTO_MAX_NUMBER;

public class DefaultLottoRandomNumberGenerator implements LottoRandomNumberGenerator {
	private List<Integer> lottoNumbers;

	public DefaultLottoRandomNumberGenerator () {
		lottoNumbers = new ArrayList<>();
	}

	public List<Integer> numbers (List<Integer> getRandomNumber) {
		lottoNumbers.addAll(getRandomNumber);
		return lottoNumbers;
	}

	public List<Integer> randomNumber (Integer length) {
		List<Integer> randoms = new ArrayList<>();

		for (int i = 0; i < length; i++) {
			Random random = new Random();
			int randomNumber = random.nextInt(LOTTO_MAX_NUMBER) + 1;

			if (checkDuplicate(randomNumber)) {
				randoms.add(randomNumber);
			}
		}

		return randoms;
	}

	private Boolean checkDuplicate (int aRandomNumber) {
		if (lottoNumbers.contains(aRandomNumber)) {
			return Boolean.TRUE;
		}

		return Boolean.FALSE;
	}
}
