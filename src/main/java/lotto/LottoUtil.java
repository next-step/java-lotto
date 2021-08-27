package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LottoUtil {

	public static final int MAX = 45;
	public static final int MIN = 1;

	public static List<List<Integer>> createRandomLottoNumbers(int count, int lottoNumberCount) {
		ArrayList<List<Integer>> lottoGroup = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			lottoGroup.add(createLottoNumber(lottoNumberCount));
		}
		return lottoGroup;
	}

	private static List<Integer> createLottoNumber(int lottoNumberCount) {
		Random random = new Random();
		ArrayList<Integer> lotto = new ArrayList<>();
		for (int i = 0; i < lottoNumberCount; ) {
			int number = random.nextInt(MAX) + MIN;
			if (!lotto.contains(number)) {
				lotto.add(number);
				i++;
			}
		}
		lotto.sort(Integer::compareTo);
		return lotto;
	}
}
