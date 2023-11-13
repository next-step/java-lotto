package step2.view;

import step2.domain.*;

import java.text.DecimalFormat;

public class LottoResultView {

    private static final String LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String LOTTO_RESULT_MESSAGE = "%d개 일치, (%d원)- %d개";
    private static final String LOTTO_EARNED_RATE_MESSAGE = "총 수익률은 %s입니다.";

    public static void printPurchaseComplete(Lottos list){
        System.out.println(String.format(LOTTO_COUNT_MESSAGE, list.getLottoCount()));
        printList(list);
    }

    public static void printList(Lottos lottos){
        for(Lotto t: lottos.getLottos()){
            System.out.println(t.lottoNumbers());
        }
    }

    public static void printResultTest(WinningInfos winningInfos, Lottos lottos) {
        printResultTitle();

        for(WinningInfo info : winningInfos.winningInfoList()){
            printEachWinning(info);
        }

        printEarningRate(winningInfos.earningRate());
    }

    private static void printEachWinning(WinningInfo info) {
        System.out.println(String.format(LOTTO_RESULT_MESSAGE, info.matchCount(), info.winningMoney(), info.winningCount()));
    }

    private static void printResultTitle() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    private static void printEarningRate(double earningRate) {
        DecimalFormat df = new DecimalFormat("#.##");
        String format = df.format(earningRate);
        System.out.println(String.format(LOTTO_EARNED_RATE_MESSAGE, format));
    }
}
