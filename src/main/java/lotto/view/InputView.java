package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public String money() {
        System.out.println("구입금액을 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public String winningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public String bonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return SCANNER.nextLine();
    }


    public String countByPurchaseManually() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public List<String> purchaseManually(int countByPurchaseManually) {
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        List<String> result = new ArrayList<>();
        for (int i = 0; i < countByPurchaseManually; i++) {
            result.add(SCANNER.nextLine());
        }
        return result;
    }
}
