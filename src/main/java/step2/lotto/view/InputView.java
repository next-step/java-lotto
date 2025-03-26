package step2.lotto.view;

import java.util.Scanner;
import step2.lotto.domain.Lotto;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getPaidMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = scanner.nextInt();
        scanner.nextLine();
        return money;
    }

    public static Lotto lastWeekLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new Lotto(scanner.nextLine());
    }
}
