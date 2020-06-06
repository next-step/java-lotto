package step3.view.view;

import step3.domain.Lotto;
import step3.domain.LottoTickets;
import step3.domain.Prize;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * OutputView
 * ver. 1.0
 * 2020.05.31
 * Copyright ...
 */
public class OutputView {

    private static final String NUMBER_DELIMITER = ",";

    public static void outputLottoList(LottoTickets lottoTickets) {

        System.out.println("You bought (a) " + lottoTickets.getLottoTicketsSize() + " games.");

        lottoTickets.getLottoTickets().forEach(lotto -> {
            printNumbers(lotto);
        });

    }


    private static void printNumbers(Lotto lotto) {

        StringBuilder stringBuilder = new StringBuilder("[");
        stringBuilder.append(lotto.getNumbers()
                .stream()
                .map(number -> String.format("%3d", number))
                .collect(Collectors.joining(NUMBER_DELIMITER)));
        stringBuilder.append("]");

        System.out.println(stringBuilder);

    }

    public static void outputPrizeList() {

        System.out.println("-------------");
        System.out.println("PRIZE !! LIST");
        System.out.println("-------------");

        Arrays.stream(Prize.values()).forEach(prize -> {
            System.out.println(prize.getMatchedNumber()
                    + " matched. (" + String.format("%15d", prize.getPrizePrice())
                    + ") : " + String.format("%3d", prize.getPrizeCount()) + (prize.isBonusNumberMatching() ? " with Bonus Number Match." : ""));

        });
    }


    public static void outputWinningResult(BigDecimal totalResult) {
        System.out.println("-------------");
        System.out.println("Total Profit Ratio : " + totalResult);
        System.out.println("-------------");

    }
}
