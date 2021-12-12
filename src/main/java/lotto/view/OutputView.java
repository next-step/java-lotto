package lotto.view;

import lotto.Number;
import lotto.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OutputView {

    private static final String OUTPUT_MESSAGE_HOW_MANY_LOTTOS_BOUGHT = "%d개를 구매했습니다.\n";
    private static final String OUTPUT_MESSAGE_LOTTO_RESULT_ANNOUNCE = "\n당첨 통계\n" + "---------";
    private static final String OUTPUT_MESSAGE_PROFIT_ANNOUNCE = "총 수익률은 %.3f 입니다. \n";
    private static final String OUTPUT_MESSAGE_X_NUMBERS_MATCH = "%d개 일치 (%d원)- %d개\n";
    private static final String NUMBER_CONNECTOR = ", ";
    private static final String NUMBER_START_SIGNAL = "[";
    private static final String NUMBER_END_SIGNAL = "]";
    private static final String END_LINE_SIGNAL = "\n";

    public void showHowManyLottosBoughtWithMoney(Lottos lottos) {
        System.out.printf(OUTPUT_MESSAGE_HOW_MANY_LOTTOS_BOUGHT, lottos.count());
    }

    public void showLottos(Lottos lottos) {
        StringBuilder result = new StringBuilder();
        for(Lotto lotto: lottos.getLottos()) {
            Numbers numbers = lotto.getLottoNumbers();
            result.append(buildNumbers(numbers)).append(END_LINE_SIGNAL);
        }

        System.out.println(result);
    }

    public StringBuilder buildNumbers(Numbers numbers) {
        StringBuilder result = new StringBuilder();
        List<Number> numberList = numbers.getNumbers();
        List<String> stringNumbers = new ArrayList<>();

        for(Number number : numberList) {
            stringNumbers.add(String.valueOf(number.getNumber()));
        }

        String numbersToString = String.join(NUMBER_CONNECTOR, stringNumbers);
        result.append(NUMBER_START_SIGNAL);
        result.append(numbersToString);
        result.append(NUMBER_END_SIGNAL);

        return result;
    }

    public void showMatchCount(Lotto winnerLotto, Lottos lottos) {
        for(LottoWin lottoWin : LottoWin.LOTTO_WINS) {
            int winMatchCount = lottoWin.numberOfMatch();
            int matchedCount = lottos.calculateMatchCount(winnerLotto, winMatchCount);

            System.out.printf(
                    OUTPUT_MESSAGE_X_NUMBERS_MATCH,
                    winMatchCount,
                    lottoWin.winPrice().getMoney().longValue(),
                    matchedCount
            );
        }
    }

    public void showLottoProfit(BigDecimal profit) {
        System.out.println(OUTPUT_MESSAGE_LOTTO_RESULT_ANNOUNCE);
        System.out.printf(OUTPUT_MESSAGE_PROFIT_ANNOUNCE, profit.doubleValue());
    }

}
