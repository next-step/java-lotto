package lotto.view;

import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Rank;

public class OutputView {

    public static final String ERROR_MESSAGE = "[ERROR] ";
    public static final String ERROR_WRONG_LOTTO_PRICE = "로또 한 장은 1000원입니다. 잘못된 금액입니다.";
    private static final String REQUEST_LOTTO_PRICE = "구입금액을 입력해 주세요.";
    private static final String SYSTEM_LOTTO_COUNT = "개를 구매했습니다.";
    private static final String REQUEST_WINNING_NUMBER_BEFORE = "\n지난 주 당첨 번호를 입력해주세요.(ex 1, 2, 3, 4, 5)";
    private static final String REQUEST_BONUS_BALL_NUMBER = "보너스 볼을 입력해주세요.";
    private static final String WINNING_STATS = "\n당첨 통계\n------------";
    private static final int CASE_BONUS_BALL_MONEY = 30000000;

    private OutputView() {
    }

    public static void printExceptionMessage(String exceptionMessage) {
        System.out.println(ERROR_MESSAGE + exceptionMessage);
    }

    public static void printRequestLottoPrice() {
        System.out.println(REQUEST_LOTTO_PRICE);
    }

    public static void printLottoCount(int count) {
        System.out.println(count + SYSTEM_LOTTO_COUNT);
    }

    public static void printWinningNumberBefore() {
        System.out.println(REQUEST_WINNING_NUMBER_BEFORE);
    }

    public static void printBonusBallNumber() {
        System.out.println(REQUEST_BONUS_BALL_NUMBER);
    }

    public static void printLottoStatisticTitle() {
        System.out.println(WINNING_STATS);
    }

    public static void printLottoStatistic(int grade, int money, int matchOfNumber) {
        if (money == CASE_BONUS_BALL_MONEY) {
            System.out.println(grade + "개 일치, 보너스 볼 일치(" + money + "원) - " + matchOfNumber + " 개");
        }
        if (money != CASE_BONUS_BALL_MONEY) {
            System.out.println(grade + "개 일치(" + money + "원) - " + matchOfNumber + " 개");
        }
    }

    public static void printTotalReturn(Double earningRate) {
        String profitOrLoss = "손해";

        if (earningRate >= 1) {
            profitOrLoss = "이득";
        }

        System.out.println(
            "총 수익률은 " + earningRate + "입니다.(기준이 1이기 때문에 결과적으로 " + profitOrLoss + "이라는 의미임)");
    }

    public static void printLottoStatistics(Map<Rank, Integer> rankReport) {
        OutputView.printLottoStatisticTitle();
        for (Rank rank : rankReport.keySet()) {
            OutputView.printLottoStatistic(rank.getGrade(), rank.getMoney(), rankReport.get(rank));
        }
    }

    public static void printLottoNumbers(List<Lotto> lottoLists) {
        for (Lotto lotto : lottoLists) {
            OutputView.printLottoNumber(lotto);
            System.out.println();
        }
    }

    public static void printLottoNumber(Lotto lottoNumbers) {
        Set<LottoNumber> lottoList = lottoNumbers.getLotto();
        for (LottoNumber lottoNumber : lottoList) {
            System.out.printf(lottoNumber.getLottoNumber() + " ");
        }
    }
}
