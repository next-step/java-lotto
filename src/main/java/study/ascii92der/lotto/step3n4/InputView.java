package study.ascii92der.lotto.step3n4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNER_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);
    public static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    public static LottoPrice inputMoney() {
        System.out.println(INPUT_MONEY);
        return new LottoPrice(Integer.parseInt(scanner.nextLine()));
    }

    public static List<String> inputWinnerNumbers() {
        System.out.println(INPUT_WINNER_NUMBERS);
        return new ArrayList<>(Arrays.asList(scanner.nextLine().split(",")));
    }
    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return Integer.parseInt(scanner.nextLine());
    }
}
