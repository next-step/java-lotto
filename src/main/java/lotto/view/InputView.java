package lotto.view;

import java.util.Scanner;

public class InputView {

    static Scanner scanner = new Scanner(System.in);

    public static int inputAmount(){
        System.out.println("로또 구입 금액을 입력해 주세요.");
        return scanner.nextInt();
    }
}
