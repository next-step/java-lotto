package lotto.View;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputPurchaseAmount() {
        System.out.println("구매 금액을 입력해주세요.");
        int result =  SCANNER.nextInt();
        clearInputBuffer();
        return result;
    }

    public static String inputWinNumber(){
        System.out.println("지난주 당첨 번호 6개 입력해 주세요. ex) 1, 2, 3, 4, 5, 6");
        return SCANNER.nextLine();
    }

    private static void clearInputBuffer() {
        SCANNER.nextLine();
    }



}
