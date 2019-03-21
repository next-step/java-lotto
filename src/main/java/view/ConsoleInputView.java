package view;

import util.StringParser;

import java.util.Scanner;

public class ConsoleInputView {
    private static Scanner scanner = new Scanner(System.in);

    public static Integer inputPrice(){
        System.out.println("구매금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static Integer[] inputWinningNumbers(){
        System.out.println("지난 주 당첨번호를 입력해주세요.");
        String str = scanner.next();

        return StringParser.strToIntegerArray(str);
    }

    public static Integer inputBonusNumber() {
        System.out.println("보너스 볼을 입력해주세요.");

        return scanner.nextInt();
    }
}
