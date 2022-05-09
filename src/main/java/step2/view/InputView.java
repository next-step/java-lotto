package step2.view;

import step2.domain.PurchaseLotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요");
        return scanner.nextInt();
    }

    public String lottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        scanner.nextLine();
        return scanner.nextLine();
    }

    public String bonusBall() {
        System.out.println("보너스 볼을 입력해 주세요");
        return scanner.next();
    }

    public List<String> manualPick() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int count = scanner.nextInt();

        List<String> list = new ArrayList<>();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < count; i++) {
            list.add(scanner.next());
        }
        return list;
    }

    public void resultPurchase(PurchaseLotto purchaseLotto) {
        System.out.println("수동으로 " + purchaseLotto.getManualCount() + "장, 자동으로 " +  purchaseLotto.getAutoCount() + "개를 구매했습니다.");
    }
}
