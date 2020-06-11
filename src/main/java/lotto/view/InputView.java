package lotto.view;

import lotto.util.ConvertInt;
import lotto.util.Split;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputBuyAmount() {
        System.out.println(TextFixture.INPUT_AMOUNT_FOR_BUY_LOTTO);
        int buyAmount = scanner.nextInt();
        scanner.nextLine();
        return buyAmount;
    }

    public static List<Integer> inputWinningNumber() {
        System.out.println(TextFixture.INPUT_WINNING_LOTTO_NUMBERS);
        String input = scanner.nextLine();
        return ConvertInt.from(Split.from(input, ","));
    }

    public static int inputBonusNumber() {
        System.out.println(TextFixture.INPUT_WINNING_LOTTO_BONUS_NUMBERS);
        int bonus = scanner.nextInt();
        scanner.nextLine();
        return bonus;
    }

    public static int inputManualLottoCount() {
        System.out.println(TextFixture.INPUT_BUY_MANUAL_COUNT);
        int count = scanner.nextInt();
        scanner.nextLine();
        return count;
    }

    public static List<List<Integer>> inputManualLottos(int count) {
        List<List<Integer>> lottos = new ArrayList<>();
        if (count < 0) {
            return lottos;
        }

        System.out.println(TextFixture.INPUT_BUY_MANUAL_NUMBERS);
        for (int i = 0; i < count; i++) {
            String input = scanner.nextLine();
            lottos.add(ConvertInt.from(Split.from(input, ",")));
        }
        return lottos;
    }
}
