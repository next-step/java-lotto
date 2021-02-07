package lotto.view;

import java.util.Scanner;

public class InputHandler {

    private final Scanner sc = new Scanner(System.in);

    public String requestPriceFromUser() {
        System.out.println("구매금액을 입력해 주세요. (로또 1장당 1000원)");
        return sc.nextLine();
    }

    public Integer requestNumberOfManualTicket() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(sc.nextLine());
    }

    public String requestManualTicketNumber(int manualCount) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < manualCount; i++) {
            stringBuilder.append(sc.nextLine()).append('\n');
        }
        return stringBuilder.toString();
    }

    public String requestWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return sc.nextLine();
    }

    public String requestBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return sc.nextLine();
    }
}
