package lotto.view;

import lotto.enumset.InitEnum;
import lotto.model.LottoOneLine;
import lotto.model.LottoAllLine;
import lotto.enumset.LottoEnum;
import lotto.enumset.StandardNumberEnum;

import java.util.List;

public class OutputView {

    private static LottoAllLine lottoAllLine;

    public static void printGameCount(int autoGameCount, int manualGameCount){
        String printMessage = "\n수동으로 ".concat(Integer.toString(manualGameCount))
                                         .concat("장 자동으로 ")
                                         .concat(Integer.toString(autoGameCount))
                                         .concat("장을 구매 했습니다.");
        System.out.println(printMessage);
    }

    public static void printPurchaseLottoNumber(List <LottoOneLine> lottos) {
        for (LottoOneLine lottoOneLine : lottos) {
            System.out.println(lottoOneLine.lottoNumber());
        }
    }

    public static void printWinnerSummary(LottoAllLine inputLottoAllLine) {
        lottoAllLine = inputLottoAllLine;
        System.out.println();
        for (int i = 0; i < InitEnum.LOTTO_DEFAULT_WINNER_TYPE.value(); i++) {
            System.out.println(summaryPrintGenerator(i));
        }
    }

    public static void printRateOfReturn(int intputLotteGamePrice) {
        System.out.println("총 수익률은 " + lottoAllLine.rateOfReturn(intputLotteGamePrice) + " 입니다.");
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
        printText.append(lottoAllLine.lottoSummaryWinnerCount(lottoWinnerPrice));
        printText.append("개");
        return printText.toString();
    }

    private static int winnerCount(int eventWinnerCount) {
        if (isWinner(eventWinnerCount)) {
            return eventWinnerCount + StandardNumberEnum.LOTTO_BONUS_INDEX_BELOW_CHARGE.value();
        }
        return eventWinnerCount + StandardNumberEnum.LOTTO_BONUS_INDEX_MORETHEN_CHARGE.value();
    }

    private static boolean isWinner(int eventWinnerCount){
        return eventWinnerCount >= StandardNumberEnum.LOTTO_BONUS_PRINT_NUMBER_INDEX.value();
    }

    private static boolean isBonusWinner(int eventWinnerCount) {
        return eventWinnerCount == StandardNumberEnum.LOTTO_BONUS_PRINT_NUMBER_INDEX.value();
    }

    private static String printBonusTest(boolean isBonusWinnerState) {
        if (isBonusWinnerState) {
            return ", 보너스 번호 일치 ";
        }
        return "";
    }

}
