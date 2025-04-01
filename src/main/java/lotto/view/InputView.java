package lotto.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public int readNumberOfManuallyPickedTickets() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    public String readManualNumbers() {
        return scanner.nextLine();
    }

    public String readWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public int readBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }


}
