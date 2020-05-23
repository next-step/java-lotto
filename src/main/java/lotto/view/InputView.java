package lotto.view;

import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER = ",";

    private InputView() {

    }

    public static int inputLottoBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static List<Lotto> inputWinningNumbers() {
        SCANNER.nextLine();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winners = SCANNER.nextLine();
        return Arrays.stream(winners.split(DELIMITER))
                .map(String::trim)
                .map(number -> new Lotto(Integer.parseInt(number)))
                .collect(Collectors.toList());
    }
}
