package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public int inputGameMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public int inputManualTicketCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public List<String> inputManualTicketTexts(int count) {
        List<String> ticketTexts = new ArrayList<>();

        if(count < 0) {
            return ticketTexts;
        }

        System.out.println("수동으로 구입할 번호를 입력해주세요");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < count; i++) {
            ticketTexts.add(scanner.next());
        }
        return ticketTexts;
    }

    public String inputWinText() {
        System.out.println("지난 주 당첨 번호를 입력해주세요");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
