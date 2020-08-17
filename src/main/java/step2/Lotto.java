package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lotto {
	private static final int LOTTO_PRICE = 1000;
	private static final int MAX_LOTTO_VALUE = 46;
	private static final int MAX_LOTTO_NUMBER = 6;
	private static final Random random = new Random();

	public static int getLottoCountByPrice(int price) {
		return price / LOTTO_PRICE;
	}

	public static List<Integer[]> issueAutoLotto(int count) {
		List<Integer[]> autoLottos = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			autoLottos.add(issueOneAutoLotto());
		}
		return autoLottos;
	}

	private static Integer[] issueOneAutoLotto() {
		Integer[] oneLotto = new Integer[MAX_LOTTO_NUMBER];
		for (int i = 0; i < MAX_LOTTO_NUMBER; i++) {
			oneLotto[i] = random.nextInt(MAX_LOTTO_VALUE);
		}
		return oneLotto;
	}
}
