package step2.view;

import java.util.Arrays;
import java.util.HashMap;
import step2.model.Lotteries;

public class OutputView {

	private static final int DEFAULT_COUNT = 0;

	public void resultView(HashMap<Integer, Integer> finalMatch) {

		System.out.println("당첨 통계");
		System.out.println("--------");

		for (int key = 3; key < 7; key++) {
			showResult(key, isValid(finalMatch.get(key)));
		}
	}

	private int isValid(Integer matchSum) {

		if (matchSum == null) {
			return DEFAULT_COUNT;
		}
		return matchSum;
	}

	private void showResult(int key, int matchSum) {

		if (key == 3) {
			System.out.println("3개 일치" + "(5000원)- " + matchSum + "개");
		}
		if (key == 4) {
			System.out.println("4개 일치" + "(50000원)- " + matchSum + "개");
		}
		if (key == 5) {
			System.out.println("5개 일치" + "(1500000원)- " + matchSum + "개");
		}
		if (key == 6) {
			System.out.println("6개 일치" + "(2000000000원)- " + matchSum + "개");
		}
	}

	public void showTotalTicket(int tickets) {
		System.out.println(tickets + "매를 구매했습니다");
	}

	public void showLotteries(int tickets, Lotteries lotteries) {
		for (int i = 0; i < tickets; i++) {
			System.out.println(Arrays.toString(lotteries.showLotteries(i).getLotto().toArray()));
		}
	}

	public void showRate(String rate) {
		System.out.println("수익률은 " + rate + "입니다");
	}


}
