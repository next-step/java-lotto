package lotto.views;

import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private static void clearInputBuffer() {
        scanner.nextLine();
    }

    public static int payment() {
        System.out.println("구입 금액을 입력해 주세요.");
        final int result = scanner.nextInt();
        clearInputBuffer();
        return result;
    }

    private static int manualLottoTicketsCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        final int result = scanner.nextInt();
        clearInputBuffer();
        return result;
    }

    private static List<String> manualLottoTickets(int count) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        final List<String> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(scanner.nextLine());
        }
        return result;
    }

    public static String winnerNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static String bonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextLine().trim();
    }
}
