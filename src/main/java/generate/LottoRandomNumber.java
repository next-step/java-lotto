package generate;

import java.util.Arrays;
import java.util.Random;

public class LottoRandomNumber {
	private static final Integer LOTTO_NUMBER_LENGTH = 6;

	public static Integer[] numbers () {
		Integer[] lottoNumbers = new Integer[6];

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
