package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String SPLIT_REGEX = ", ";

    public static int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static Set<Integer> pickWinNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winNumberString = SCANNER.nextLine();
        return Arrays.stream(winNumberString.split(SPLIT_REGEX)).map(Integer::parseInt).collect(Collectors.toSet());
    }

    public static int pickBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static int getManualLotteryTicketCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static List<String> enterManualLotteryNumbers(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("갯수는 음수일 수 없습니다");
        }

        List<String> numbersString = new ArrayList<>();
        SCANNER.nextLine();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < count; i++) {
            numbersString.add(SCANNER.nextLine());
        }
        return numbersString;
    }

}
