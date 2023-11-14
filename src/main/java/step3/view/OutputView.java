package step3.view;

import step3.domain.Lotto;
import step3.domain.LottoRank;
import step3.domain.Lottos;
import step3.domain.WinningResult;

import java.text.DecimalFormat;
import java.util.Map;

public class OutputView {

    private static final String LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_MESSAGE = "%d개 일치 (%d원)- %d개";
    private static final String EARNING_RATE_MESSAGE = "총 수익률은 %s입니다.";

    public static void printPurchaseComplete(Lottos lottos){
        printLottoCount(lottos);
        printEachLotto(lottos);
    }

    private static void printLottoCount(Lottos lottos) {
        System.out.println(String.format(LOTTO_COUNT_MESSAGE, lottos.lottos().size()));
    }

    private static void printEachLotto(Lottos lottos) {
        for(Lotto lotto: lottos.lottos()){
            System.out.println(lotto);
        }
    }


    public static void print(WinningResult result) {
        printTitle();
        printRankInfo(result);
        printFinalEarningRate(result);
    }

    private static void printFinalEarningRate(WinningResult result) {
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println(String.format(EARNING_RATE_MESSAGE, df.format(result.getEarningRate())));
    }

    private static void printRankInfo(WinningResult result) {
        for(Map.Entry<LottoRank, Integer> info : result.getResult().entrySet()){
            System.out.println(String.format(WINNING_MESSAGE, info.getKey().matchCount(), info.getKey().winningMoney(), info.getValue()));
        }
        ;
    }

    private static void printTitle() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }
}
