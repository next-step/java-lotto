package step2;

import java.util.Scanner;

public class InputView {

    private Scanner scan = new Scanner(System.in);

    public int inputCash() {
        System.out.println("구입금액을 입력해 주세요.");
        String cash = scan.nextLine();
        if (cash.isEmpty()) {
            throw new IllegalArgumentException("구매금액이 없으면, 로또구매가 불가합니다.");
        }
        return Integer.parseInt(cash);
    }

    public String[] inputwinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scan.nextLine().split(",");
    }
}
