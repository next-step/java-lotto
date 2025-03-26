package lotto.view.input;

import lotto.domain.UserPaid;
import lotto.domain.product.LotteryTicket;

import java.util.Scanner;

public class ConsoleInputView extends BaseInputView {

    static Scanner scanner = new Scanner(System.in);

    @Override
    public String read() {
        return scanner.nextLine();
    }

    public UserPaid purchase() {
        System.out.println("구입 금액을 입력 해 주세요.");
        return new UserPaid(scanner.nextLine());
    }

    @Override
    public void closeScanner() {
        scanner.close();
    }

    @Override
    public LotteryTicket lastWeekNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new LotteryTicket(scanner.nextLine());
    }
}
