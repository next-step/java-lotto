package lotto_auto.io;

import java.util.Scanner;

public class InputView {
    public int budget;
    public String magicNumber;

    public InputView() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        budget = scanner.nextInt();
    }

    public void getMagicNumberComment() {
        System.out.println("\n지난 주 당첨 번호를 입력 해주세요.");
        Scanner scanner = new Scanner(System.in);
        magicNumber = scanner.nextLine();
    }
}
