package lotto.view;

import lotto.util.NumberUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return NumberUtil.getPositiveInteger(SCANNER.nextLine());
    }

    public static int inputManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return NumberUtil.getPositiveInteger(SCANNER.nextLine());
    }

    public static List<Integer> inputLottoNumber() {
        String inputText = SCANNER.nextLine();
        String[] tokens = inputText.split(",");

        return Arrays.stream(tokens)
                .map(String::trim)
                .map(NumberUtil::getPositiveInteger)
                .collect(Collectors.toList());
    }

    public static List<Integer> inputWinnigNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return inputLottoNumber();
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return SCANNER.nextInt();
    }
}
