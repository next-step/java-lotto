package lotto.view;

import java.util.Scanner;

public class InputView {

    public int buyLottoView() {
        System.out.println("구입금액을 입력해주세요.");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

}
