package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getMoneyForTicket() {
        System.out.println("구입금액을 입력해 주세요.");
        return getIntInput();
    }

    public static List<Integer> getLastWeekWinnerNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        String inputString = scanner.nextLine();
        try {
            return Arrays.stream(inputString.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요");
        }
    }

    public static int getLastWeekBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return getIntInput();
    }

    private static int getIntInput() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자로 입력해주세요");
        }
    }
}
