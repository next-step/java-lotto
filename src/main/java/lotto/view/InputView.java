package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final String MONEY_INSERT = "구입금액을 입력해 주세요.";
    private static final String LAST_WEEK_LOTTO_INPUT = "지난 주 당첨 번호를 입력해 주세요.";

    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int getMoney() {
        System.out.println(MONEY_INSERT);

        return Integer.parseInt(scanner.nextLine());
    }

    public String getLastWeekLottoNumbers() {
        System.out.println(LAST_WEEK_LOTTO_INPUT);

        return scanner.nextLine();
    }
}
