package generate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static domain.Lotto.LOTTO_MAX_NUMBER;
import static domain.Lotto.LOTTO_NUMBER_LENGTH;

public class LottoRandomNumber {


	public static List<Integer> numbers () {
		List<Integer> lottoNumbers = new ArrayList<>();

		for (int i = 0; i < LOTTO_NUMBER_LENGTH; i++) {
			Random random = new Random();

			int randomNumber = random.nextInt(LOTTO_MAX_NUMBER)+1;

			if (checkDuplicate(lottoNumbers, randomNumber)) {
				lottoNumbers.add(randomNumber);
				continue;
			}

			i--;
		}
		return lottoNumbers;
	}

	private static Boolean checkDuplicate(List<Integer> lottoNumbers, int aRandomNumber){
		return !lottoNumbers.contains(aRandomNumber);
	}
}
