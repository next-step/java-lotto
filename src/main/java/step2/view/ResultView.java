package step2.view;

import step2.domain.Lotto.Lotto;
import step2.domain.winning.WinningAmount;
import step2.domain.winning.Winnings;

import java.util.List;

public class ResultView {

    public void start() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void purchaseHistory(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.getNums()));
    }

    public void lastWeeksWinningNum() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public void result(Winnings winnings) {
        System.out.println("\n당첨 통계\n---------");
        System.out.printf("3개 일치 (%d원)- %s개\n", WinningAmount.FIRST.getAmount(), winnings.getForth());
        System.out.printf("4개 일치 (%d원)- %s개\n", WinningAmount.SECOND.getAmount(), winnings.getThird());
        System.out.printf("5개 일치 (%d원)- %s개\n", WinningAmount.THIRD.getAmount(), winnings.getSecond());
        System.out.printf("6개 일치 (%d원)- %s개\n", WinningAmount.FORTH.getAmount(), winnings.getFirst());
    }

    public void rate(double rate) {
        System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", rate);
    }

}
