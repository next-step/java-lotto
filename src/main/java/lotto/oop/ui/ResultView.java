package lotto.oop.ui;

import lotto.oop.domain.IssueStats;
import lotto.oop.domain.Rank;

public class ResultView {
    private IssueStats result;

    public ResultView(IssueStats result) {
        this.result = result;
    }

    public void displayIssueStats() {
        System.out.println("당첨 통계");
        System.out.println("________");
        System.out.println("3개 일치 (5,000원)- " + result.checkCount(Rank.FIFTH) + "개");
        System.out.println("4개 일치 (50,000)- " + result.checkCount(Rank.FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원)- " + result.checkCount(Rank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30,000,000원)- " + result.checkCount(Rank.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원)- " + result.checkCount(Rank.FIRST) + "개");
        displayGrossReturn();
    }

    private void displayGrossReturn() {
        double totalGrossReturn = result.getGrossReturn();
        String msg = "총 수익률은 " + Math.floor((totalGrossReturn) * 100) / 100.0 + "입니다.";
        if (totalGrossReturn < 1d) {
            msg += " (기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        }
        System.out.println(msg);
    }
}