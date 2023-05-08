package step2.view;

import step2.domain.PurchasedLotto;
import step2.domain.Ranking;

public class ResultView {

    public void winningNumberComment() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
    }

    public void bonusNumberComment() {
        System.out.println("보너스 번호를 입력해주세요.");
    }

    public void printStatics(PurchasedLotto purchasedLotto) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("-------");
        System.out.printf(
            "3개 일치 (5000 원)- %d개", purchasedLotto.getCountOfRank(Ranking.FIFTH)
        ).println();
        System.out.printf(
            "4개 일치 (50,000 원)- %d개", purchasedLotto.getCountOfRank(Ranking.FOURTH)
        ).println();
        System.out.printf(
            "5개 일치 (1,500,000 원)- %d개", purchasedLotto.getCountOfRank(Ranking.THIRD)
        ).println();
        System.out.printf(
            "5개 일치, 보너스 볼 일치 (30,000,000 원)- %d개", purchasedLotto.getCountOfRank(Ranking.SECOND)
        ).println();
        System.out.printf(
            "6개 일치 (2,000,000,000 원)- %d개", purchasedLotto.getCountOfRank(Ranking.FIRST)
        ).println();
        System.out.println();
    }

    public void printProfit(int money, PurchasedLotto purchasedLotto) {
        System.out.printf("총 수익률은 %s 입니다.", purchasedLotto.getRateOfReturn(money)).println();
    }
}
