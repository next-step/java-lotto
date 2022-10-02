package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoResult;
import lotto.domain.PurchaseMoney;
import lotto.domain.enums.LottoRank;
import lotto.domain.enums.LottoReward;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String FORMAT_RESULT = "%d개 일치 (%d원) - %d개%n";
    private static final String FORMAT_RESULT_EARNING_RATE = "총 수익률은 %.2f입니다.";
    private static final String FORMAT_COUNT = "%d개를 구매했습니다.%n";
    private static final String HORIZON = "-".repeat(20);


    private OutputView(){

    }

    public static void printCount(int lottoCount) {
        System.out.printf(FORMAT_COUNT,lottoCount);
    }

    public static void printLottoGame(LottoGame lottoGame) {

        List<Lotto> lottos = lottoGame.getValue();

        for (Lotto lotto : lottos) {
            String collect = lotto.getValue().stream().map(String::valueOf).collect(Collectors.joining(","));
            System.out.println("["+collect+"]");
        }
    }

    public static void printResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println(HORIZON);
        System.out.printf(FORMAT_RESULT, LottoRank.FOURTH.getMatchCount(), LottoReward.FOURTH.getReward(), lottoResult.getCount(LottoRank.FOURTH));
        System.out.printf(FORMAT_RESULT, LottoRank.THIRD.getMatchCount(), LottoReward.THIRD.getReward(), lottoResult.getCount(LottoRank.THIRD));
        System.out.printf(FORMAT_RESULT, LottoRank.SECOND.getMatchCount(), LottoReward.SECOND.getReward(), lottoResult.getCount(LottoRank.SECOND));
        System.out.printf(FORMAT_RESULT, LottoRank.FIRST.getMatchCount(), LottoReward.FOURTH.getReward(), lottoResult.getCount(LottoRank.FIRST));
    }
    public static void printEarningRate(PurchaseMoney purchaseMoney, LottoResult lottoResult){
        System.out.printf(FORMAT_RESULT_EARNING_RATE, purchaseMoney.getEarningRate(lottoResult));
    }
}
