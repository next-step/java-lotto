package lotto.view;

import java.util.Scanner;


public class InputView {

    public static long PurchaseAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("로또를 구입할 금액을 주세요.");
        return scanner.nextLong();
    }

    public String InputWinningNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("당첨번호를 입력해주세요. 숫자 6개([Number,Number,Number,Number,Number,Number]");
        return scanner.nextLine();
    }

    public int InputBonusNumber() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("보너스 숫자를 입력해 주세요.숫자 1개[Number]");
        return scanner.nextInt();
    }
}