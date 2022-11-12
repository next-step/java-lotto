package lotto.ui;

import lotto.LottoNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String QUERY_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String QUERY_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String QUERY_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String QUERY_MANUAL_PURCHASE_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String QUERY_MANUAL_LOTTO_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String LOTTO_NUMBERS_SEPERATOR = ", ";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {

    }

    public static int queryPurchasePrice() {
        System.out.println(QUERY_PURCHASE_PRICE_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public static int queryManualPurchaseCount() {
        System.out.println(QUERY_MANUAL_PURCHASE_COUNT_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<List<Integer>> queryManualLottoNumbers(int count) {
        System.out.println(QUERY_MANUAL_LOTTO_NUMBERS_MESSAGE);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(queryLottoNumbers());
        }
        return result;
    }

    public static List<Integer> queryWinningNumbers() {
        System.out.println(QUERY_WINNING_NUMBERS_MESSAGE);
        return queryLottoNumbers();
    }

    private static List<Integer> queryLottoNumbers() {
        return Arrays.stream(scanner.nextLine().split(LOTTO_NUMBERS_SEPERATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static Integer queryBonusNumber() {
        System.out.println(QUERY_BONUS_NUMBER_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }
}
