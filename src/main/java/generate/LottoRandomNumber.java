package generate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static domain.Lotto.LOTTO_NUMBER_LENGTH;

public class LottoRandomNumber {


	public static List<Integer> numbers () {
		List<Integer> lottoNumbers = new ArrayList<>();

		for (Integer i = 0; i < LOTTO_NUMBER_LENGTH; i++) {
			Random random = new Random();

			Integer randomNumber = random.nextInt(44)+1;

			if (checkDuplicate(lottoNumbers, randomNumber)) {
				lottoNumbers.add(randomNumber);
				continue;
			}

			i--;
		}
		return lottoNumbers;
	}

	private static Boolean checkDuplicate(List<Integer> lottoNumbers, int aRandomNumber){
		return !Arrays.asList(lottoNumbers).contains(aRandomNumber);
	}
}
