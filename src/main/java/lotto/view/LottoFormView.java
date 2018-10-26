package lotto.view;

import java.util.Scanner;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.domain.WinningLotto;

public class LottoFormView {
    public static Money inputMoney(Scanner scanner) {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(scanner.nextLine());
        return new Money(money);
    }
    
    public static WinningLotto inputWinningLotto(Scanner scanner) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningLotto = scanner.nextLine();

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus = Integer.parseInt(scanner.nextLine());
        return new WinningLotto(Lotto.ofComma(winningLotto), LottoNumber.of(bonus));
    }
}
