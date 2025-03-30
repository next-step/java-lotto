package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoInputView {
    public static final Scanner SCANNER = new Scanner(System.in);

    public int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = SCANNER.nextInt();
        SCANNER.nextLine();
        System.out.println();
        return amount;
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] numberTexts = SCANNER.nextLine().split(", ");

        List<Integer> result = new ArrayList<>();
        for (String numberText : numberTexts) {
            result.add(Integer.parseInt(numberText));
        }
        return result;
    }

    public int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = SCANNER.nextInt();
        SCANNER.nextLine();
        System.out.println();
        return bonusNumber;
    }
}
