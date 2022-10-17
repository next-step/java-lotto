package lotto.view.input;

import java.util.Scanner;

import lotto.model.BonusNumber;

public class BonusNumberInputView {

    public static BonusNumber getBonusNumber(Scanner scanner) {
        System.out.println("보너스 볼을 입력해 주세요.");
        BonusNumber bonusNumber = BonusNumber.of(scanner.nextInt());
        scanner.nextLine();

        return bonusNumber;
    }
}
