package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Game {
	public static void start(int input) {
		int amount = validAmount(input) / 1000;
		Print.amount(amount);

		startRaffle(amount);
	}

	public static void startRaffle(int amount) {
		Lotto lotto = new Lotto();
		List<Set<Integer>> list = new ArrayList<>();
		for (int i = 1; i <= amount; i++) {
			Set<Integer> result = lotto.getRandomLotto(new Random().nextInt(39));
			Print.result(result);
			list.add(result);
		}
		Result result = new Result(list);
	}

	private static int validAmount(int inputAmount) {
		if (inputAmount < 1000) {
			throw new IllegalArgumentException("최소 금액은 1000원 입니다");
		}
		return inputAmount;
	}
}
