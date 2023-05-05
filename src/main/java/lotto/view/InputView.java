package lotto.view;

import java.util.Scanner;

public class InputView {
    public static Scanner scanner = new Scanner(System.in);

    public static int inputMoney(){
        System.out.println("구매금액을 입력해 주세요.");
        return scanner.nextInt();
    }

}
