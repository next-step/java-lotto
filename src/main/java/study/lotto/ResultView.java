package study.lotto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResultView {
    private static final List<Integer> matchCountForPrize = new ArrayList<>(Arrays.asList(3,4,5,6));

    private LottoGame lottoGame;


    public ResultView(LottoGame lottoGame) {
        this.lottoGame = lottoGame;
    }


    public void winningResult() {
        System.out.println("\n당첨 통계");
        System.out.println("----------");
        lottoGame.checkPrize();
        printPrize();
        printProfitRate();
    }

    private void printProfitRate() {
        StringBuffer message = new StringBuffer();
        BigDecimal winningPrizeAmount = lottoGame.winningLottos().winningPrizeAmount();
        BigDecimal rate = winningPrizeAmount.divide(lottoGame.purchaseAmout());
        message.append("총 수익률은 ")
                .append(rate)
                .append("입니다.")
                .append(additionalMessage(rate));
        System.out.println(message);

    }

    private String additionalMessage(BigDecimal rate) {
        if (rate.compareTo(BigDecimal.ONE) < 0){
            return "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        }
        return "";
    }

    private void printPrize() {
        for (Integer matchCount : matchCountForPrize) {
            System.out.println(matchCount+"개 일치 "+WinningPrize.prize(matchCount)+"원-"+ lottoGame.winningLottos().prizeCount(matchCount));
        }
    }


}
