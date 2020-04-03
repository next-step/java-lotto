package lotto2.view;

import lotto2.domain.GameResult;
import lotto2.domain.Lotto;
import lotto2.domain.Money;
import lotto2.domain.Prize;

import java.util.List;

public class OutputView {

    public void showInputResult(final List<Lotto> lottos, Money money) {
        StringBuilder sb = new StringBuilder();
        sb.append(System.getProperty("line.separator"));
        sb.append(money.getLottoCount() + "개를 구매했습니다.");
        sb.append(System.getProperty("line.separator"));

        for (Lotto lotto : lottos) {
            sb.append(lotto);
            sb.append(System.getProperty("line.separator"));
        }

        System.out.println(sb.toString());
    }

    public void showResult(GameResult gameResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Prize prize : Prize.values()) {
            showGameResult(prize, gameResult);
        }
    }

    /**
     * 3개 일치 (5000원)- 1개
     *
     * @param prize
     * @param gameResult
     */
    private void showGameResult(Prize prize, GameResult gameResult) {

        System.out.println(String.format("%d개 일치 (%d원)- %d개",
                prize.getMatch(),
                prize.getAmount(),
                gameResult.getWinResult(prize)));
    }

    public void showProfit(final Money purchasedAmount, final GameResult gameResult) {
        System.out.println("총 수익률은 " + gameResult.getProfit(purchasedAmount) + "%입니다.");
    }


}
