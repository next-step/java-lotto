package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static int getMoney(String question, Scanner scanner) {
        System.out.println(question);
        readInteger(scanner);
        return scanner.nextInt();
    }

    public static List<Integer> getWinningLottoNumbers(String question, String regex, Scanner scanner) {
        System.out.println(question);
        readString(scanner);
        String str = scanner.nextLine();

        return Arrays.stream(str.split(regex))
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    private static void readInteger(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.err.print("숫자를 입력하세요> ");
        }
    }

    private static void readString(Scanner scanner) {
        while (!scanner.hasNext()) {
            scanner.next();
            System.err.print("지난 주 당첨 번호를 입력해 주세요.> ");
        }
    }
}
