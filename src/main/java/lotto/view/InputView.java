package lotto.view;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

/**
 * Created by yusik on 2019/11/05.
 */
public class InputView {

    private static final String DELIMITER = ",";
    private final Scanner scanner;

    public InputView(InputStream in) {
        scanner = new Scanner(in);
    }

    public int receiveAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String amount = scanner.nextLine();
        return Integer.parseUnsignedInt(amount.trim());
    }

    public List<Integer> receiveWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] winningNumbers = scanner.nextLine().split(DELIMITER);
        return Arrays.stream(winningNumbers)
                .map(String::trim)
                .map(Integer::parseUnsignedInt)
                .collect(toList());
    }

    public int receiveBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        String bonusNumber = scanner.nextLine();
        return Integer.parseUnsignedInt(bonusNumber.trim());
    }
}
