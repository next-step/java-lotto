package view;

import java.util.ArrayList;
import java.util.List;

import domain.lotto.Lotto;
import domain.lotto.LottoNumber;
import domain.lotto.LottoResult;
import domain.lotto.Lottos;
import domain.lotto.Rank;

public class ResultView {

	public void printLottos(Lottos lottos) {
		System.out.println(lottos.getLottos().size() + "개를 구매했습니다.");
		for (Lotto lotto : lottos.getLottos()) {
			printLotto(lotto);
		}
	}

	private void printLotto(Lotto lotto) {
		List<Integer> numbers = new ArrayList<>();
		for (LottoNumber number : lotto.getNumbers()) {
			numbers.add(number.getNumber());
		}
		System.out.println(numbers);
	}

	public void printResult(LottoResult result, int money) {
		System.out.println();
		System.out.println("당첨 통계");
		System.out.println("---------");
		for (Rank rank : List.of(Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST)) {
			System.out.println(rank.getMatchCount() + "개 일치 (" + rank.getPrize() + "원)- "
				+ result.countOf(rank) + "개");
		}
		printProfitRate(result.profitRate(money));
	}

	private void printProfitRate(double profitRate) {
		String message = "총 수익률은 " + profitRate + "입니다.";
		if (profitRate < 1) {
			message += "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
		}
		System.out.println(message);
	}
}
