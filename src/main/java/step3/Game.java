package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Game {
	public static void start(int input) {
		LottoAmount lottoMoney = new LottoAmount(input);
		int amount = lottoMoney.amountOfLottos();

		Print.amount(amount);

		Result guestResult = startRaffle(amount);
		Print.winningNumber();

		Print.rateOfWin(input, guestResult.results(makeWinningResult(InputView.input().split(", "))));
	}

	public static Set<Integer> makeWinningResult(String[] winningNumbers) {
		Set<Integer> list = new TreeSet<>();
		for (String winningNumber : winningNumbers) {
			list.add(Integer.parseInt(winningNumber));
		}
		return list;
	}

	public static Result startRaffle(int amount) {
		LottoFactory lotto = new LottoFactory();
		List<Set<Integer>> list = new ArrayList<>();
		for (int i = 1; i <= amount; i++) {
			Set<Integer> result = lotto.getRandomLotto();
			Print.result(result);
			list.add(result);
		}
		Print.newLine();
		return new Result(new Lottos(list));
	}
}
