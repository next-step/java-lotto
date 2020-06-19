package step4.view;

import step4.domain.LottoGame;
import step4.domain.lotto.Lotto;
import step4.domain.lotto.LottoTickets;
import step4.domain.prize.Prize;
import step4.domain.prize.PrizeCount;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * OutputView
 * ver. 1.0
 * 2020.05.31
 */
public class OutputView {

    private static final String NUMBER_DELIMITER = ",";

    public static void outputLottoList(LottoGame lottoGame) {
        LottoTickets lottoTickets = lottoGame.getLottoTickets();
        System.out.println("You bought (a) " + lottoTickets.getLottoTickets().size() + " games.");
        lottoTickets.getLottoTickets().forEach(lotto -> {
            printNumbers(lotto);
        });
    }

    private static void printNumbers(Lotto lotto) {
        StringBuilder stringBuilder = new StringBuilder("[");
        stringBuilder.append(lotto.getNumbers()
                .stream()
                .map(number -> String.format("%3d", number.getLottoNo()))
                .collect(Collectors.joining(NUMBER_DELIMITER)));
        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }

    public static void outputPrizeList(PrizeCount prizeCount) {
        System.out.println("-------------");
        System.out.println("PRIZE !! LIST");
        System.out.println("-------------");
        Arrays.stream(Prize.values()).forEach(prize -> {
            System.out.println(prize.getMatchedNumber()
                    + " matched. (" + String.format("%15d", prize.getPrizePrice())
                    + ") : " + String.format("%3d", prizeCount.getPrizeSum(prize)) + (prize.isBonusNumberMatching() ? " with Bonus Number Match." : ""));
        });
    }

    public static void outputWinningResult(BigDecimal totalResult) {
        System.out.println("-------------");
        System.out.println("Total Profit Ratio : " + totalResult);
        System.out.println("-------------");
    }

}
