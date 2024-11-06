package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Money;
import lotto.domain.Winners;

import java.util.Scanner;

public class UserInput {

    /**
     * 구입금액을 입력해 주세요.
     * 14000
     */
    public static Money inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return new Money(scanner.nextInt());
    }

    /**
     * 지난 주 당첨 번호를 입력해 주세요.
     * 1, 2, 3, 4, 5, 6
     * 보너스 볼을 입력해 주세요.
     * 7
     */
    public static Winners inputWinners() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println("보너스 볼을 입력해 주세요.");
        scanner = new Scanner(System.in);
        LottoNumber bonusNumber = new LottoNumber(scanner.nextInt());
        return new Winners(new LottoNumbers(str), bonusNumber);
    }
}
