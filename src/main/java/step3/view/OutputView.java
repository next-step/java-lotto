package step3.view;

import step3.domain.*;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private static final String LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_MESSAGE = "%d개 일치 (%d원)- %d개";
    private static final String WINNING_MESSAGE_BONUS = "%d개 일치, 보너스 볼 일치 (%d원)- %d개";
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
            String lottoNumbers = lotto.lottoNumbers().stream()
                    .map(LottoNumber::number)
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ", "[", "]"));
            System.out.println(lottoNumbers);
        }
    }


    public static void print(WinningResult result) {
        printTitle();
        printRankInfo(result);
        printFinalEarningRate(result);
    }

    private static void printTitle() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    private static void printRankInfo(WinningResult result) {
        for(Map.Entry<LottoRank, Integer> info : result.winningResult().entrySet()){
            printEach(info);
        }
    }

    private static void printEach(Map.Entry<LottoRank, Integer> info) {
        LottoRank rank = info.getKey();
        if(rank.isSecond()){
            System.out.println(String.format(WINNING_MESSAGE_BONUS, rank.matchCount(), rank.winningMoney(), info.getValue()));
            return;
        }
        System.out.println(String.format(WINNING_MESSAGE, rank.matchCount(), rank.winningMoney(), info.getValue()));
    }

    private static void printFinalEarningRate(WinningResult result) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        System.out.println(String.format(EARNING_RATE_MESSAGE, decimalFormat.format(result.getEarningRate())));
    }

}
