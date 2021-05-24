package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.entity.LottoList;
import lotto.domain.entity.Rank;

import java.math.BigDecimal;

public final class OutputView {
    private static final String BUY_LOTTO_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_COMPLETION_MESSAGE = "%d 개를 구매했습니다. \n";
    private static final String WINNERS_MESSAGE = "%s가 최종 우승했습니다.";
    private static final String WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String PROFIT_RATE_RESULT_MESSAGE = "총 수익률은 %.2f 입니다.";

    private static final String HYPHEN = "---------";

    private static final String FIRST_MESSAGE = "6개 일치 (2000000000원)- %d개 \n";
    private static final String SECOND_MESSAGE = "5개 일치 (1500000원)- %d개 \n";
    private static final String THIRD_MESSAGE =  "4개 일치 (50000원)- %d개 \n";
    private static final String FOURTH_MESSAGE = "3개 일치 (5000원)- %d개 \n";

    public static void printBuyLotto() {
        System.out.println(BUY_LOTTO_MESSAGE);
    }

    public static void printPurchaseCompletion(int lottoCount) {
        System.out.printf(PURCHASE_COMPLETION_MESSAGE, lottoCount);
    }

    public static void printLottoList(LottoList lottoList) {
        for (int i = 0; i < lottoList.size(); i++) {
            System.out.print("[");
            printNumbers(lottoList.get(i));
            System.out.println("]");
        }
    }

    private static void printNumbers(Lotto lotto) {
        StringBuilder lottoList = new StringBuilder();
        for (int i = 0; i < lotto.size(); i++) {
            lottoList.append(lotto.get(i).getNumber()).append(",");
        }
        System.out.print(lottoList.substring(0, lottoList.length() - 1));
    }

    public static void printReceiveWinningNumber() {
        System.out.println(WINNING_NUMBER_MESSAGE);
    }

    public static void printStatistics(BigDecimal profitRate, Rank rank) {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(HYPHEN);
        System.out.printf(FIRST_MESSAGE, rank.first());
        System.out.printf(SECOND_MESSAGE, rank.second());
        System.out.printf(THIRD_MESSAGE, rank.third());
        System.out.printf(FOURTH_MESSAGE, rank.fourth());
        System.out.printf(PROFIT_RATE_RESULT_MESSAGE, profitRate);
    }

}
