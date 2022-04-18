package lotto;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.Arrays.*;

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

    public List<Integer> insertWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        scanner.nextLine();
        String winningLotto = inputScannerString();

        return stream(winningLotto.split(WINNING_LOTTO_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private String inputScannerString() {
        return scanner.nextLine();
    }

}
