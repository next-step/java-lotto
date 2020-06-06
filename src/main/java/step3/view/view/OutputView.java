package step3.view.view;

import step2.domain.Lotto;
import step2.domain.Prize;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/*
 * OutputView
 * ver. 1.0
 * 2020.05.31
 * Copyright ...
 */
public class OutputView {

    private static final String NUMBER_DELIMITER = ",";

    public static void outputLottoList(List<Lotto> lottoList) {

        System.out.println("You bought (a) " + lottoList.size() + " games.");

        lottoList.forEach(lotto -> {
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

    public static void outputPrizeList(List<Prize> prizeList) {

        System.out.println("-------------");
        System.out.println("PRIZE !! LIST");
        System.out.println("-------------");

        prizeList.forEach(prize -> {
            System.out.println(prize.getMatchedNumber()
                    + " matched. (" + String.format("%15d", prize.getPrizePrice())
                    + ") : " + String.format("%3d", prize.getPrizeCount()));
        });

    }


    public static void outputWinningResult(BigDecimal totalResult) {
        System.out.println("-------------");
        System.out.println("Total Profit Ratio : " + totalResult);
        System.out.println("-------------");

    }
}
