package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String LOTTO_NUMBER_SEPARATOR = ", ";

    private static final String ASK_BUY_PRICE_MENT = "구입금액을 입력해 주세요.";
    private static final String ASK_MANUALLY_BUY_COUNT_MENT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String ASK_MANUALLY_BUY_LOTTO_NUMBERS_MENT = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String ASK_WIN_LOTTO_NUMBER_MENT = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String ASK_BONUS_LOTTO_NUMBER_MENT = "보너스 볼을 입력해 주세요.";

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int askBuyPrice() {
        System.out.println(ASK_BUY_PRICE_MENT);
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static int askManuallyBuyCount() {
        System.out.println(ASK_MANUALLY_BUY_COUNT_MENT);
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static List<List<Integer>> askManuallyBuyLottoNumbers(final int manuallyBuyCount) {
        List<List<Integer>> manuallyLottonumbers = new ArrayList<>();
        if (manuallyBuyCount > 0) {
            addManuallyLottoNumbers(manuallyBuyCount, manuallyLottonumbers);
        }
        return manuallyLottonumbers;
    }

    private static void addManuallyLottoNumbers(int manuallyBuyCount, final List<List<Integer>> manuallyLottonumbers) {
        System.out.println(ASK_MANUALLY_BUY_LOTTO_NUMBERS_MENT);
        while (manuallyBuyCount-- > 0) {
            manuallyLottonumbers.add(
                    Arrays.stream(SCANNER.nextLine().split(LOTTO_NUMBER_SEPARATOR))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList())
            );
        }
        System.out.println();
    }

    public static List<Integer> askWinLottoNumber() {
        System.out.println(ASK_WIN_LOTTO_NUMBER_MENT);
        return Arrays.stream(SCANNER.nextLine().split(LOTTO_NUMBER_SEPARATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static Integer askBonusLottoNumber() {
        System.out.println(ASK_BONUS_LOTTO_NUMBER_MENT);
        return Integer.parseInt(SCANNER.nextLine());
    }

}
