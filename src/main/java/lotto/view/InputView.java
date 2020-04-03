package lotto.view;

import lotto.util.ScannerUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static lotto.util.MessageUtil.*;

public class InputView {
    private static final int MINIMUM_MONEY_TO_BUY = 1000;
    private static final String COMMA = ",";

    private static int lottoCount;
    private static int lottoCountManual;
    private static int lottoCountAuto = lottoCount - lottoCountManual;

    public static int getInputForMoney() {
        printMessage(MESSAGE_MONEY_INPUT);
        int money = ScannerUtil.readInt();
        validateGreaterThan1000(isGreaterThan1000(money));
        lottoCount = money / MINIMUM_MONEY_TO_BUY;
        return lottoCount;
    }

    public static int getInputForLottoCountManual() {
        printMessage(MESSAGE_LOTTO_COUNT);
        lottoCount = ScannerUtil.readInt();
        validatePurchasable(isPurchasable(lottoCount));
        lottoCountManual = lottoCount;
        return lottoCountManual;
    }

    public static List<List<Integer>> getInputForLottoManual() {
        printMessage(MESSAGE_LOTTO_MANUAL);

        List<List<Integer>> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCountManual; i++) {
            lottos.add(splitByComma(ScannerUtil.readLine()));
        }

        return lottos;
    }

    public static List<Integer> getInputForWinningLotto() {
        printMessage(MESSAGE_WINNING_LOTTO);
        return splitByComma(ScannerUtil.readLine());
    }

    public static Integer getInputForBonusBall() {
        printMessage(MESSAGE_BONUS_BALL);
        return ScannerUtil.readInt();
    }

    private static boolean isPurchasable(int lottoCountManul) {
        return lottoCountManul <= lottoCount;
    }

    private static void validatePurchasable(boolean isPurchasable) {
        if (!isPurchasable) {
            System.out.println(WARNING_LOTTO_COUNT);
            getInputForLottoCountManual();
        }
    }

    private static boolean isGreaterThan1000(int money) {
        return money >= MINIMUM_MONEY_TO_BUY;
    }

    private static void validateGreaterThan1000(boolean isGreaterThan1000) {
        if (!isGreaterThan1000) {
            System.out.println(WARNING_MONEY_INPUT);
            getInputForMoney();
        }
    }

    private static List<Integer> splitByComma(String input) {
        return Arrays.stream(input.split(COMMA))
                .map(it -> ScannerUtil.convertStringToInteger(it))
                .collect(toList());
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }
}