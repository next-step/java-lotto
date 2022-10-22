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
		String[] lastweekLotto = InputView.input().split(", ");
		Print.bonusBall();
		String bonus = InputView.input();

		Print.rateOfWin(input, guestResult.results(makeWinningResult(lastweekLotto), Integer.parseInt(bonus)));
	}

	public static Lotto makeWinningResult(String[] winningNumbers) {
		return new Lotto(winningNumbers);
	}

	public static Result startRaffle(int amount) {
		LottoFactory lotto = new LottoFactory();
		List<Lotto> list = new ArrayList<>();
		for (int i = 1; i <= amount; i++) {
			Lotto result = new Lotto(lotto.getRandomLotto());
			Print.result(result);
			list.add(result);
		}
		Print.newLine();
		return new Result(new Lottos(list));
	}
}
