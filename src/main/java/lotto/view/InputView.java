package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static int getMoney(String question, Scanner scanner) {
        System.out.println(question);
        readInteger(scanner);
        return scanner.nextInt();
    }

    public static int getManualCount(String question, Scanner scanner) {
        System.out.println(question);
        readInteger(scanner);
        return scanner.nextInt();
    }

    public static List<String> getManualLottoNumbers(String question, Scanner scanner, int manualCount) {
        System.out.println(question);
        List<String> manualNumbers = new ArrayList<>();

        readString(scanner);
        scanner.nextLine();

        for (int i = 0; i < manualCount; i++) {
            manualNumbers.add(scanner.nextLine());
        }
        return manualNumbers;
    }

    public static int getBonusNumber(String question, Scanner scanner) {
        System.out.println(question);
        readInteger(scanner);
        return scanner.nextInt();
    }

    public static String getWinningLottoNumbers(String question, Scanner scanner) {
        System.out.println(question);
        readString(scanner);

        return scanner.nextLine();
    }

    private static void readInteger(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.err.print("숫자를 입력하세요> ");
        }
    }

    private static void readString(Scanner scanner) {
        while (!scanner.hasNext()) {
            scanner.nextLine();
            System.err.print("번호를 입력해 주세요.> ");
        }
    }
}
