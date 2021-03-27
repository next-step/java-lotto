package im.juniq.lotto.view;

import im.juniq.lotto.LotteryMachine;
import im.juniq.lotto.Lotto;
import im.juniq.lotto.Lottoes;
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

	public static void winningStatus(LotteryMachine lotteryMachine) {
		System.out.println("당첨통계");
		System.out.println("---------");
		System.out.println("3개 일치 (" + Winning.THREE_NUMBERS_MATCHED.amount() + "원)- " + lotteryMachine.numberOfLottoesMatched(3) + "개");
		System.out.println("4개 일치 (" + Winning.FOUR_NUMBERS_MATCHED.amount() + "원)- " + lotteryMachine.numberOfLottoesMatched(4) + "개");
		System.out.println("5개 일치 (" + Winning.FIVE_NUMBERS_MATCHED.amount() + "원)- " + lotteryMachine.numberOfLottoesMatched(5) + "개");
		System.out.println("6개 일치 (" + Winning.SIX_NUMBERS_MATCHED.amount() + "원)- " + lotteryMachine.numberOfLottoesMatched(6) + "개");
		System.out.println("총 수익률은 " + lotteryMachine.yield() + "입니다.");
	}

	private static void addSeparatorIfNotFirst(int index) {
		if (index != 0) {
			System.out.print(", ");
		}
	}
}
