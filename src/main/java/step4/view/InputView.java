package step4.view;


import step4.domain.Money;
import step4.domain.WinningLotto;
import step4.dto.LottoInformation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public LottoInformation inputLottoInfo() {
        Money money = inputMoney();
        List<String> manualList = inputManual();

        return new LottoInformation(money, manualList);
    }

    private Money inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String moneyStr = scanner.nextLine();
        return Money.of(moneyStr);
    }

    private List<String> inputManual() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualCount = Integer.parseInt(scanner.nextLine());

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> manualLottos = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            manualLottos.add(scanner.nextLine());
        }
        return manualLottos;
    }

    public WinningLotto inputWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        String winningLottoString = scanner.nextLine();
        System.out.println("보너스 볼을 입력해 주세요.");
        String bonusString = scanner.nextLine();
        return WinningLotto.of(winningLottoString, bonusString);
    }

}
