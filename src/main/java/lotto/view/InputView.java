package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
        throw new IllegalArgumentException();
    }

    public static int getMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static int getManualTicketCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요");
        return SCANNER.nextInt();
    }

    public static List<String> getManualLottoNumbers(int count) {
        SCANNER.nextLine();
        List<String> stringLottoNumbers = new ArrayList<>();
        System.out.println("수동으로 구매할 번호를 입력해 주세요");
        for (int i = 0; i < count; i++) {
            stringLottoNumbers.add(SCANNER.nextLine());
        }
        return stringLottoNumbers;
    }

    public static String getWinnerTicket() {
        SCANNER.nextLine();
        System.out.println("지난주 당첨 번호를 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public static int getBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요");
        return SCANNER.nextInt();
    }
}
