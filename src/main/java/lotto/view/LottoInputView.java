package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER_REGEX = "[,\\s]+";

    public int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int result = SCANNER.nextInt();
        SCANNER.nextLine();
        return result;
    }

    public List<Integer> getWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return toNumbers(SCANNER.nextLine());
    }

    private List<Integer> toNumbers(String text) {
        return Arrays.stream(text.split(DELIMITER_REGEX))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
