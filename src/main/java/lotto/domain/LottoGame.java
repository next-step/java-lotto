package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoGame {
	private static final int LOTTO_PRICE = 1000;
	public int calculateLottoCount(int input) {
		return input/LOTTO_PRICE;
	}

	public List<Integer> generateLottoNumber() {
		Random random = new Random();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			list.add(random.nextInt(45)+1);
		}
		Collections.shuffle(list);
		return list;
	}
}
