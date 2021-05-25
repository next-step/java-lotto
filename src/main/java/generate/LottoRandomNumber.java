package generate;

import java.util.Arrays;
import java.util.Random;

import static domain.Lotto.LOTTO_NUMBER_LENGTH;

public class LottoRandomNumber {


	public static Integer[] numbers () {
		Integer[] lottoNumbers = new Integer[LOTTO_NUMBER_LENGTH];

		for (Integer i = 0; i < LOTTO_NUMBER_LENGTH; i++) {
			Random random = new Random();

			Integer randomNumber = random.nextInt(44)+1;

			if (checkDuplicate(lottoNumbers, randomNumber)) {
				lottoNumbers[i] = randomNumber;
				continue;
			}

			i--;
		}
		return lottoNumbers;
	}

	private static Boolean checkDuplicate(Integer[] lottoNumbers, int aRandomNumber){
		return !Arrays.asList(lottoNumbers).contains(aRandomNumber);
	}
}
