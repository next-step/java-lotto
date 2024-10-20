package lotto.ui;

import lotto.OneTimeRoundLottoNumberList;

import java.util.List;

public class PrintView {
    public static final int[] LOTTO_WINNING_AMOUNT_ARRAY = {5000, 50000, 1500000, 2000000000};

    public static void printLottoTryCount(int lottoTryCount) {
        System.out.println(lottoTryCount + "개를 구매했습니다.");

    }

    public static void printLottoList(List<OneTimeRoundLottoNumberList> lottoNumberList) {
        for (OneTimeRoundLottoNumberList numberList : lottoNumberList) {
            System.out.println(numberList);
        }
    }

    public static void printWinningStatisticsPreview() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public static void printMatchingCount(List<Integer> lottoNumberMatchCountList) {
        for (int i = 0; i < lottoNumberMatchCountList.size(); i++) {
            System.out.printf("%d개 일치 (%d원)- %d개\n", i + 3, LOTTO_WINNING_AMOUNT_ARRAY[i], lottoNumberMatchCountList.get(i));
        }
    }

    public static void printMargin( double profitMargin) {
        System.out.println("총 수익률은 " + profitMargin + "입니다.");

    }

}
