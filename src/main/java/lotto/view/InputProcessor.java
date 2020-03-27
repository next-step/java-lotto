package lotto.view;

import java.util.List;
import java.util.Scanner;

public class InputProcessor {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextLine();
    }

    public static List<Integer> getWinningLotto() {
        System.out.println("지난 주 당첨번호를 입력해 주세요.");
       return StringConverter.convertStringToNumbers(scanner.nextLine());
    }
}