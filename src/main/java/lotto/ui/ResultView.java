package lotto.ui;

import java.util.List;

public class ResultView {
	public static final String INFO_INTRO = "당첨 통계\n---------";
	public static final String FORMAT_PROFIT = "총 수익률은 %.2f 입니다.%n";
	public static final String FORMAT_STATISTICS = "%d개 일치 (%s) - %d개%n";

	public void outputIntro() {
		System.out.println(INFO_INTRO);
	}

	public void outputStatistics(int index, String won, int count) {
		System.out.printf(FORMAT_STATISTICS, index, won, count);
	}

	public void outputProfit(double rate) {
		System.out.printf(FORMAT_PROFIT, rate);
	}

	public void printNumbers(List<Integer> numbers) {
		System.out.println(numbers);
	}
}

