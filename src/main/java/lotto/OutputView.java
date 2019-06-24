package lotto;

import java.util.List;

public class OutputView {

    private static int DEFAULT_LOTTO_WINNER_TYPE = 4;
    private static LottoGames lottoGames;

    static void printPurchaseLottoNumber(List <Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.lottoNumber());
        }
    }

    static void printWinnerSummary(LottoGames inputLottoGamess) {
        lottoGames = inputLottoGamess;
        for (int i = 0; i < DEFAULT_LOTTO_WINNER_TYPE; i++) {
            System.out.println(summaryPrintGenerator(i));
        }
    }

    static void printRateOfReturn() {
        System.out.println("총 수익률은 " + lottoGames.rateOfReturn() + " 입니다.");
    }

    private static String summaryPrintGenerator(int eventWinnerCount) {
        int printNumber = eventWinnerCount + 3;
        int lottoWinnerPrice = LottoEnum.findByPrice(printNumber).price();

        StringBuilder printText = new StringBuilder();
        printText.append(printNumber);
        printText.append("개 일치 (");
        printText.append(lottoWinnerPrice);
        printText.append(") - ");
        printText.append(lottoGames.lottoSummaryWinnerCount(lottoWinnerPrice));
        printText.append("개");
        return printText.toString();
    }

}
