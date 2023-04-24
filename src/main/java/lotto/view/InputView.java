package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.exception.SameNumberException;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ",";

    public static Money inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return Money.initMoney(scanner.nextInt());
    }

    public static Lotto inputWinningNumbers() {
        scanner.nextLine();
        System.out.println("지난 주 당첨 번호를 압력해주세요.");
        return Lotto.initWinningLotto(List.of(scanner.nextLine().split(DELIMITER)));
    }
}
