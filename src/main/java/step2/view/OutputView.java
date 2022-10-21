package step2.view;

import java.util.Arrays;
import java.util.HashMap;
import step2.model.Lotteries;

public class OutputView {

	private static final int DEFAULT_COUNT = 0;
	private static final int MIN_WIN_COUNT = 3;
	private static final int MAX_WIN_COUNT = 6;
	private static final int BENEFIT_STANDARD = 1;

	public void resultView(HashMap<Integer, Integer> finalMatch) {
		System.out.println("당첨 통계");
		System.out.println("--------");

		for (int key = MIN_WIN_COUNT; key < MAX_WIN_COUNT + 1; key++) {
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
		if (key == MIN_WIN_COUNT) {
			System.out.println("3개 일치" + "(5000원)- " + matchSum + "개");
		}
		if (key == MIN_WIN_COUNT + 1) {
			System.out.println("4개 일치" + "(50000원)- " + matchSum + "개");
		}
		if (key == MIN_WIN_COUNT + 2) {
			System.out.println("5개 일치" + "(1500000원)- " + matchSum + "개");
		}
		if (key == MIN_WIN_COUNT) {
			System.out.println("6개 일치" + "(2000000000원)- " + matchSum + "개");
		}
	}

	public void showTotalTicket(int tickets) {
		System.out.println(tickets + "매를 구매했습니다");
	}

	public void showLotteries(int tickets, Lotteries lotteries) {
		for (int i = 0; i < tickets; i++) {
			System.out.println(lotteries.showLotteries(i).getLotto().toArray());
		}
	}

	public void showRate(double rate) {
		if (checkRate(rate)) {
			System.out.println("수익률은 " + String.format("%.2f", rate) + "입니다");
			return;
		}
		System.out.println(
			"수익률은 " + String.format("%.2f", rate) + "입니다(기준이 1이기 때문에 결과적으로 손해라는 의미임");
	}

	private boolean checkRate(double rate) {
		if (rate < BENEFIT_STANDARD) {
			return false;
		}
		return true;
	}


}
