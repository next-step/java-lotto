package lotto;

import java.math.BigDecimal;
import java.util.Scanner;

public class InputView {
    public BigDecimal inputPayAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        BigDecimal payAmount = scanner.nextBigDecimal();
        return payAmount;
    }
}
