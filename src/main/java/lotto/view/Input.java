package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;

import java.util.Scanner;

public class Input {

    private Scanner scanner;

    public Input(Scanner scan) {
        scanner = scan;
    }

    public Money inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int inputMoney = scanner.nextInt();
        return new Money(inputMoney);
    }

    public Lotto inputLastWinningNumber() {

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String inputLastWinningNumber = scanner.next();

        if (isEmptyOrBlank(inputLastWinningNumber)) {
            throw new IllegalArgumentException("값이 입력되지 않았습니다.");
        }

        return new Lotto(inputLastWinningNumber);
    }

    private Boolean isEmptyOrBlank(String inputName) {
        return inputName == null || inputName.trim().isEmpty();
    }

    public LottoNumber inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonus = scanner.nextInt();
        return new LottoNumber(bonus);
    }
}
