package lotto.presentation;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);


    public int inputPurchasePrice() {
        System.out.println("구입 금액을 입력해주세요.");
        int price = SCANNER.nextInt();

        //엔터 제거
        SCANNER.nextLine();

        return price;
    }

    public String inputWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.nextLine();
    }
}
