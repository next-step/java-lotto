package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lotto.domain.Money;

public class InputView {

    private Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public Money getMoneyToBuyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = scanner.nextLine();
        return new Money(input);
    }

    public int getManualLottoCnt() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        int ManualLottoCnt = scanner.nextInt();
        return ManualLottoCnt;
    }

    public List<String> getManualLottoNumberList(int manualLottoCnt) {
        List<String> manualNumberList = new ArrayList<>();
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < manualLottoCnt; i++) {
            String ManualLottoNumber = scanner.nextLine();
            manualNumberList.add(ManualLottoNumber);
        }
        return manualNumberList;
    }

    public String getLottoAnswer() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningLottoNumber = scanner.nextLine();
        return winningLottoNumber;
    }

    public int getBonusBall() {
        System.out.println("보너스 볼을 입력해주세요.");
        int bonusBall = scanner.nextInt();
        return bonusBall;
    }
}
