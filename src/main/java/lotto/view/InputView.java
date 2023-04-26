package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int LOTTO_PRICE = 1000;
    private static final String DELIMITER = ",";

    public static int calculateLottoCount() {
        System.out.println("구입금액을 입력해 주세요.(1000원 단위)");

        int money = SCANNER.nextInt();
        int lottoCount = money / LOTTO_PRICE;

        System.out.println(lottoCount + "개를 구매했습니다.");
        return lottoCount;
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        String winningNumbers = SCANNER.nextLine();
        return Arrays.stream(winningNumbers.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
