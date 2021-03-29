package im.juniq.lotto.view;

import im.juniq.lotto.Lotto;
import im.juniq.lotto.Lottoes;
import im.juniq.lotto.Price;
import im.juniq.lotto.Winning;
import im.juniq.lotto.WinningNumbers;

public class ResultView {
	public static void lottoes(Lottoes lottoes) {
		System.out.println(lottoes.size() + "개를 구매했습니다.");
		for (Lotto lotto : lottoes) {
			System.out.print("[");
			for (int i = 0; i < lotto.numbers().size(); i++) {
				addSeparatorIfNotFirst(i);
				System.out.print(lotto.numbers().get(i));
			}
			System.out.println("]");
		}
		System.out.println();
	}

	public static void winningStatus(Lottoes lottoes, WinningNumbers winningNumbers, Price price) {
		System.out.println("당첨통계");
		System.out.println("---------");
		System.out.println("3개 일치 (" + Winning.FOURTH.amount() + "원)- " + lottoes.numberOfLottoesMatched(3, winningNumbers) + "개");
		System.out.println("4개 일치 (" + Winning.THIRD.amount() + "원)- " + lottoes.numberOfLottoesMatched(4, winningNumbers) + "개");
		System.out.println("5개 일치 (" + Winning.SECOND.amount() + "원)- " + lottoes.numberOfLottoesMatched(5, winningNumbers) + "개");
		System.out.println("6개 일치 (" + Winning.FIRST.amount() + "원)- " + lottoes.numberOfLottoesMatched(6, winningNumbers) + "개");
		System.out.println("총 수익률은 " + lottoes.yield(winningNumbers, price) + "입니다.");
	}

	private static void addSeparatorIfNotFirst(int index) {
		if (index != 0) {
			System.out.print(", ");
		}
	}
}
