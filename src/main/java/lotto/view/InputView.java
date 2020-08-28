package lotto.view;

import java.util.Scanner;

public class InputView {
    public static int getLottoPrice() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");
        int paidMoney = Integer.parseInt(scanner.nextLine());

        return paidMoney;
    }

    public static String[] getWinningNumbers() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        String[] winningNumbers = scanner.nextLine().split(", |,");

        return winningNumbers;
    }


}
