package lotto.views;

import java.util.Scanner;

public enum InputView {
    INSTANCE;

    private final Scanner scanner = new Scanner(System.in);

    public String inputPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = scanner.nextLine();
        System.out.println();
        return input;
    }

    public String inputPurchaseCountByManual() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        String input = scanner.nextLine();
        System.out.println();
        return input;
    }

    public void printManualLottoTitle() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public String inputLottoByManual() {
        return scanner.nextLine();
    }

    public String inputLastWinner() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input =  scanner.nextLine();
        System.out.println();
        return input;
    }

    public String inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        String input = scanner.nextLine();
        System.out.println();
        return input;
    }
}
