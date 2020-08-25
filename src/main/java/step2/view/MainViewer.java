package step2.view;

import step2.domain.LottoWinners;
import step2.domain.Lottos;
import step2.utils.BuyLotto;
import step2.utils.LottoResultStatistics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainViewer {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int inputMoneyAmount = InputClass.getUserIntInput();

        BuyLotto buyLotto = new BuyLotto(inputMoneyAmount);
        System.out.println(buyLotto.buy() + "개를 구매했습니다.");

        Lottos lottos = new Lottos(buyLotto.buy());
        lottos.getLottos().forEach(lotto -> {
            System.out.println(lotto.getLotto().toString());
        });

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> winnerNumbers = InputClass.getUserStringInput();

        System.out.println("당첨 통계");
        System.out.println("-------");

        LottoWinners lottoWinners = new LottoWinners(lottos, winnerNumbers);

        LottoResultStatistics resultStatistics = new LottoResultStatistics(lottoWinners.getWinner());
        resultStatistics.getWinningPriceDetails().forEach((winner, count) -> {
            System.out.println(winner.getMatchNumber() + "개 일치" + winner.getWinedMoney() + "원-" + count + "명");
        });

        System.out.println("총 수익률은 " + resultStatistics.getFinalProfit(inputMoneyAmount) +
                "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
