package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView extends BaseView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String LOTTO_NUMBER_SEPARATOR = ",";

    public static int inputAmount() {
        printlnMessage("구입금액을 입력해 주세요.");
        int price = Integer.parseInt(scanner.nextLine());
        return price;
    }

    public static List<Set<Integer>> inputManualLottoNumbers() {
        printlnMessageAfterNewLine("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualLottoCount = Integer.parseInt(scanner.nextLine());
        printlnMessageAfterNewLine("수동으로 구매할 번호를 입력해 주세요.");
        List<Set<Integer>> manualLottoNumbers = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            manualLottoNumbers.add(inputLottoNumber());
        }
        return manualLottoNumbers;
    }

    public static Set<Integer> inputPrizeLotto() {
        printlnMessageAfterNewLine("지난 주 당첨 번호를 입력해 주세요.");
        return inputLottoNumber();
    }

    private static Set<Integer> inputLottoNumber() {
        String[] prizeNumbers = scanner.nextLine().split(LOTTO_NUMBER_SEPARATOR);
        return Arrays.stream(prizeNumbers)
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toSet());
    }

    public static int inputBonusNumber() {
        printlnMessage("보너스 볼을 입력해 주세요.");
        int bonusNumber = scanner.nextInt();
        return bonusNumber;
    }
}
