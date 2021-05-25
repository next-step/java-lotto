package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.Reward;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Output {
    private static final String INPUT_PURCHASE_MESSAGE = "구입금액을 입력해주세요.";
    private static final String PURCHASABLE_MESSAGE = "%d 개를 구매했습니다.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String WIN_STATIC_MESSAGE = "당첨 통계";
    private static final String SEPARATOR = "---------";
    private static final String YIELD_MESSAGE = "수익률은 %.2f 입니다.";
    private static final String FIFTH_PRIZE_MESSAGE = "3개 일치 (5000원)- %d 개";
    private static final String FORTH_PRIZE_MESSAGE = "4개 일치 (50000원)- %d 개";
    private static final String THIRD_PRIZE_MESSAGE = "5개 일치 (1500000원)- %d 개";
    private static final String SECOND_PRIZE_MESSAGE = "5개 일치, 보너스 볼 일치(30000000원)- %d 개";
    private static final String FIRST_PRIZE_MESSAGE = "6개 일치 (2000000000원)- %d 개";

    public static void printStartMessage() {
        System.out.println(INPUT_PURCHASE_MESSAGE);
    }

    public static void printPurchasableMessage(Integer purchased) {
        System.out.println(String.format(PURCHASABLE_MESSAGE, purchased));
    }

    public static void printLottoNumbers(Set<LottoNumber> lottoNumbers) {
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

    public static void printPrize(Map<Integer, Integer> prizes) {
        printFirstPrize(prizes.get(Reward.FIRST_PRIZE.getPrizeMoney()));
        printSecondPrize(prizes.get(Reward.SECOND_PRIZE.getPrizeMoney()));
        printThirdPrize(prizes.get(Reward.THIRD_PRIZE.getPrizeMoney()));
        printForthPrize(prizes.get(Reward.FOURTH_PRIZE.getPrizeMoney()));
        printFifthPrize(prizes.get(Reward.FIFTH_PRIZE.getPrizeMoney()));
    }

    private static void printFirstPrize(Integer winCount) {
        System.out.println(String.format(FIRST_PRIZE_MESSAGE, winCount));
    }

    private static void printSecondPrize(Integer winCount) {
        System.out.println(String.format(SECOND_PRIZE_MESSAGE, winCount));
    }

    private static void printThirdPrize(Integer winCount) {
        System.out.println(String.format(THIRD_PRIZE_MESSAGE, winCount));
    }

    private static void printForthPrize(Integer winCount) {
        System.out.println(String.format(FORTH_PRIZE_MESSAGE, winCount));
    }

    private static void printFifthPrize(Integer winCount) {
        System.out.println(String.format(FIFTH_PRIZE_MESSAGE, winCount));
    }

    public static void printYield(double yield) {
        System.out.println(String.format(YIELD_MESSAGE, yield));
    }
}
