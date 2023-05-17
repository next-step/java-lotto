package lottery.view;

import java.util.Scanner;

public class PriceInputView implements InputView<Integer> {
    Scanner scanner = new Scanner(System.in);
    @Override
    public Integer receive() {
        System.out.println("구입금액을 입력해주세요.");
        return scanner.nextInt();
    }
}
