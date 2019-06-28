package view;

import vo.Lotto;
import vo.LottoNumber;
import vo.WinningLotto;

import java.util.Scanner;

public class InputVIew {
    public String purchaseAmount() {
        System.out.println("구입 금액을 입력해주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public WinningLotto winningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String winningNumber = scanner.next();

        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = scanner.nextInt();
        return  new WinningLotto(Lotto.ofComma(winningNumber), LottoNumber.of(bonusNumber));
    }
}
