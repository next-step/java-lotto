package step4.view;

import static java.util.stream.IntStream.*;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import step4.domain.LottoOrder;
import step4.domain.WinningNumber;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public LottoOrder readLottoOrder() {
        System.out.println("구입금액을 입력해 주세요.");
        int totalPrice = scanner.nextInt();

        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualCount = scanner.nextInt();

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> manualInputs =
            range(0, manualCount)
                .mapToObj(i -> scanner.next())
                .collect(Collectors.toList());

        return LottoOrder.ofCombined(totalPrice, manualInputs);
    }

    /** 지난 주 당첨 번호 + 보너스 번호 입력 */
    public WinningNumber readWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String numbers = scanner.next();      // ex. "1,2,3,4,5,6"
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus = scanner.nextInt();
        return new WinningNumber(numbers, bonus);
    }
}
