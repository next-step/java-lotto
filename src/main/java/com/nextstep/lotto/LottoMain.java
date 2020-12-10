package com.nextstep.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoMain {
    private static final String DELIMITER = ",";
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new LottoMain().run();
    }

    public void run() {
        int price = inputPrice();
        int buyCount = LottoSeller.count(price);
        Lottos lottos = LottoSeller.buy(buyCount);
        printBuy(buyCount, lottos);
        List<Integer> winnerNumbers = inputWinnerNumbers();
        printStatistics(lottos.getStatistics(winnerNumbers));
    }

    private void printStatistics(LottoStatistics lottoStatistics) {
        System.out.println("당첨 통계");
        System.out.println("--------");
        printWinnings(lottoStatistics);
        printProfitRate(lottoStatistics);
    }

    private void printProfitRate(LottoStatistics lottoStatistics) {
        double profitRate = lottoStatistics.profitRate();
        System.out.println("총 수익률은 " + profitRate + "입니다.");
    }

    private void printWinnings(LottoStatistics lottoStatistics) {
        for (LottoWinning lottoWinning : LottoWinning.values()) {
            printWinning(lottoWinning, lottoStatistics.getCount(lottoWinning));
        }
    }

    private void printWinning(LottoWinning lottoWinning, int count) {
        if (LottoWinning.RETIRE != lottoWinning) {
            System.out.printf("%s개 일치 (%s원)- %s개", lottoWinning.getMatchedCount(), lottoWinning.getWinningPrice(), count);
            System.out.println();
        }
    }

    private List<Integer> inputWinnerNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String line = scanner.nextLine();
        System.out.println();
        return stringToList(line);
    }

    private List<Integer> stringToList(String line) {
        String[] numbers = line.split(DELIMITER);
        List<Integer> winnerNumbers = new ArrayList<>();
        for (String n : numbers) {
            int number = Integer.parseInt(n.trim());
            winnerNumbers.add(number);
        }
        return winnerNumbers;
    }

    private void printBuy(int buyCount, Lottos lottos) {
        System.out.println(buyCount + "개를 구매했습니다.");
        System.out.println(lottos.toString());
        System.out.println();
    }

    private int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String line = scanner.nextLine();
        return Integer.parseInt(line);
    }

}
