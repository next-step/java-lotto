package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class Output {
    private static final String INPUT_PURCHASE_MESSAGE = "구입금액을 입력해주세요.";
    private static final String PURCHASABLE_MESSAGE = "%d 개를 구매했습니다.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String WIN_STATIC_MESSAGE = "당첨 통계";
    private static final String SEPARATOR = "---------";
    private static final String YIELD_MESSAGE = "수익률은 %.2f 입니다.";
    private static final String MATCH_MESSAGE_3 = "3개 일치 (5000원)- %d 개";
    private static final String MATCH_MESSAGE_4 = "4개 일치 (50000원)- %d 개";
    private static final String MATCH_MESSAGE_5 = "5개 일치 (1500000원)- %d 개";
    private static final String MATCH_MESSAGE_6 = "6개 일치 (2000000000원)- %d 개";
    private static final String MATCH_MESSAGE_6_WITH_BONUS = "5개 일치, 보너스 볼 일치(30000000원)- %d 개";

    public static void printStartMessage() {
        System.out.println(INPUT_PURCHASE_MESSAGE);
    }

    public static void printPurchasableMessage(Integer purchased) {
        System.out.println(String.format(PURCHASABLE_MESSAGE,purchased));
    }

    public static void printLottoNumbers(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public static void printBunchOfLottoNumbers(List<Lotto> bunchOfLotto) {
        for (Lotto lotto : bunchOfLotto) {
            printLottoNumbers(lotto.getLottoNumbers());
        }
        System.out.println();
    }

    public static void printInputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
    }

    public static void printInputBonusBall() {
        System.out.println(INPUT_BONUS_BALL_MESSAGE);
    }

    public static void printWinStatics() {
        System.out.println(WIN_STATIC_MESSAGE);
        System.out.println(SEPARATOR);
    }

    public static void printYield(double yield) {
        System.out.println(String.format(YIELD_MESSAGE, yield));
    }

    public static void print3Match(Integer winCount) {
        System.out.println(String.format(MATCH_MESSAGE_3, winCount));
    }

    public static void print4Match(Integer winCount) {
        System.out.println(String.format(MATCH_MESSAGE_4, winCount));
    }

    public static void print5Match(Integer winCount) {
        System.out.println(String.format(MATCH_MESSAGE_5, winCount));
    }

    public static void print6Match(Integer winCount) {
        System.out.println(String.format(MATCH_MESSAGE_6, winCount));
    }

    public static void print6MatchWithBonus(Integer winCount) {
        System.out.println(String.format(MATCH_MESSAGE_6_WITH_BONUS, winCount));
    }
}
