package step1;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String insert() {
        System.out.println("계산할 식을 입력해주세요.");
        return scanner.nextLine();
    }
}
