package lotto;

import java.util.List;

public class OutputView {

    private static LottoGames lottoGames;

    static void printPurchaseLottoNumber(List <Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.lottoNumber());
        }
    }

    static void printWinnerSummary(LottoGames inputLottoGames) {
        lottoGames = inputLottoGames;
        for (int i = 0; i < NumberEnum.DEFAULT_LOTTO_WINNER_TYPE.value(); i++) {
            System.out.println(summaryPrintGenerator(i));
        }
    }

    static void printRateOfReturn(int intputLotteGamePrice) {
        System.out.println("총 수익률은 " + lottoGames.rateOfReturn(intputLotteGamePrice) + " 입니다.");
    }

    private static String summaryPrintGenerator(int eventWinnerCount) {
        int printWinnerCount = winnerCount(eventWinnerCount);
        boolean isBonusWinnerState = isBonusWinner(eventWinnerCount);
        int lottoWinnerPrice = LottoEnum.findByPrice(printWinnerCount, isBonusWinner(eventWinnerCount)).price();

        StringBuilder printText = new StringBuilder();
        printText.append(printWinnerCount);
        printText.append("개 일치 ");
        printText.append(printBonusTest(isBonusWinnerState));
        printText.append("(");
        printText.append(lottoWinnerPrice);
        printText.append(") - ");
        printText.append(lottoGames.lottoSummaryWinnerCount(lottoWinnerPrice));
        printText.append("개");
        return printText.toString();
    }

    private static int winnerCount(int eventWinnerCount) {
        if (eventWinnerCount >= NumberEnum.LOTTO_BONUS_PRINT_NUMBER_INDEX.value()) {
            return eventWinnerCount + NumberEnum.LOTTO_BONUS_INDEX_BELOW_CHARGE.value();
        }
        return eventWinnerCount + NumberEnum.LOTTO_BONUS_INDEX_MORETHEN_CHARGE.value();
    }

    private static boolean isBonusWinner(int eventWinnerCount) {
        return eventWinnerCount == NumberEnum.LOTTO_BONUS_PRINT_NUMBER_INDEX.value();
    }

    private static String printBonusTest(boolean isBonusWinnerState) {
        if (isBonusWinnerState) {
            return ", 보너스 번호 일치 ";
        }
        return "";
    }

}
