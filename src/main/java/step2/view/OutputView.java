package step2.view;

import step2.domain.Lotto;
import step2.domain.Prize;

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

        System.out.print("[");
        System.out.print(lotto.getNumbers()
                .stream()
                .map(number -> Integer.toString(number))
                .collect(Collectors.joining(NUMBER_DELIMITER)));
        System.out.println("]");

    }

    public static void outputPrizeList(List<Prize> prizeList) {

        System.out.println("-------------");
        System.out.println("PRIZE !! LIST");
        System.out.println("-------------");

        prizeList.forEach(prize -> {
            System.out.println(prize.getMatchedNumber() + " matched. (" + prize.getPrizePrice() + ") : " + prize.getPrizeCount());
        });

    }


    public static void outputWinningResult(double totalResult) {
        System.out.println("-------------");
        System.out.println("Total Profit Ratio : " + totalResult);
        System.out.println("-------------");

    }
}
