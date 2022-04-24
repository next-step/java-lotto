package lotto;

import java.util.Scanner;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class InputView {

    private static final String WINNING_LOTTO_DELIMITER = ", ";
    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public int insertLottoPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return inputScannerInt();
    }

    private int inputScannerInt() {
        return scanner.nextInt();
    }

    public Lotto insertWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        scanner.nextLine();
        String winningLotto = inputScannerString();

        return stream(winningLotto.split(WINNING_LOTTO_DELIMITER))
                .map(LottoNumber::new)
                .collect(collectingAndThen(toList(), Lotto::new));
    }

    private String inputScannerString() {
        return scanner.nextLine();
    }

    public int insertBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return inputScannerInt();
    }
}
