package lotto.view;

import utils.IntegerUtils;

import java.util.Scanner;

public class InputView {
    /*
     * 로또 구입 금액을 입력하는 뷰
     * 지난 주 당첨 번호를 입력 받는 뷰
     */
    private static Scanner scanner = new Scanner(System.in);

    public int inputBudgetView() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public String inputNumbersView() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

}
