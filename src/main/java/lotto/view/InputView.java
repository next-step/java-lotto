package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String MESSAGE_MONEY_INPUT = "구입금액을 숫자로 입력해 주세요.";
    private static final String MESSAGE_LOTTO_COUNT = "수동으로 구매할 로또 갯수를 숫자로 입력해 주세요.";
    private static final String MESSAGE_LOTTO_MANUAL = "수동으로 구매할 로또 번호를 입력하세요. (쉼표로 번호 구분)";
    private static final String WARNING_MONEY_INPUT = "구입금액은 1000원 이상만 입력 가능합니다.";
    private static final String WARNING_LOTTO_COUNT = "로또 금액이 부족합니다. 갯수를 다시 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);
    private static final int MINIMUM_MONEY_TO_BUY = 1000;

    private static int lottoCount;
    private static int lottoCountManual;
    private static int lottoCountAuto = lottoCount - lottoCountManual;

    public static int getInputForMoney() {
        System.out.println(MESSAGE_MONEY_INPUT);
        String stringMoney = scanner.nextLine();
        int money = Integer.parseInt(stringMoney);
        validateGreaterThan1000(isGreaterThan1000(money));
        lottoCount = money / MINIMUM_MONEY_TO_BUY;
        return lottoCount;
    }

    public static int getInputForLottoCountManual() {
        System.out.println(MESSAGE_LOTTO_COUNT);
        String stringLottoCount = scanner.nextLine();
        lottoCount = Integer.parseInt(stringLottoCount);
        validatePurchasable(isPurchasable(lottoCount));
        lottoCountManual = lottoCount;
        return lottoCountManual;
    }

    public static List<List<Integer>> getInputForLottoManual() {
        System.out.println(MESSAGE_LOTTO_MANUAL);

        List<List<Integer>> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCountManual; i++) {
            List<Integer> lotto;
            String stringLotto = scanner.nextLine();
            validateNullAndEmpty(isNullOrEmpty(stringLotto));
            lotto = Arrays.stream(stringLotto.split(","))
                    .map(it -> Integer.parseInt(it))
                    .collect(Collectors.toList());
            validateNullAndEmpty(isNullOrEmpty(stringLotto));
            lottos.add(lotto);
        }
        return lottos;
    }

    private static boolean isNullOrEmpty(String input){
        return (input.isEmpty() || input == null);
    }

    private static void validateNullAndEmpty(boolean isNullOrEmpty){
        if(isNullOrEmpty){
            throw new IllegalArgumentException("공백 또는 빈문자열은 입력할 수 없습니다.");
        }
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
}
