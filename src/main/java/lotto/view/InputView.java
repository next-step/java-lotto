package lotto.view;

import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Ticket;

import java.util.ArrayList;
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

    public static int getManualCount(String question, Scanner scanner) {
        System.out.println(question);
        readInteger(scanner);
        return scanner.nextInt();
    }

    public static List<Ticket> getManualLottoNumbers(String question, String regex, Scanner scanner, int manualCount) {
        System.out.println(question);
        List<Ticket> manualLottoNumbers = new ArrayList<>();

        readString(scanner);
        scanner.nextLine();

        for (int i = 0; i < manualCount; i++) {
            Ticket ticket = new Ticket(Arrays.stream(split(scanner.nextLine(), regex))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
            manualLottoNumbers.add(ticket);
        }
        return manualLottoNumbers;
    }

    private static String[] split(String string, String regex) {
        return string.split(regex);
    }

    public static int getBonusNumber(String question, Scanner scanner) {
        System.out.println(question);
        readInteger(scanner);
        return scanner.nextInt();
    }

    public static Ticket getWinningLottoNumbers(String question, String regex, Scanner scanner) {
        System.out.println(question);
        readString(scanner);
        String str = scanner.nextLine();

        return new Ticket(Arrays.stream(str.split(regex))
            .map(String::trim)
            .map(Integer::parseInt)
            .map(LottoNumber::new)
            .collect(Collectors.toList()));
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
