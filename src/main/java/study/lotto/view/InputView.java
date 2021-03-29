package study.lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static study.lotto.domain.WinningLotto.SPLIT_DELIMITER;

/**
 * View
 * 기본 라이브러리에만 의존
 */
public class InputView {

    public static final String GUIDE_LAST_WEEK_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String GUIDE_INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    public static final String GUIDE_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String GUIDE_MANUAL_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
    public static final String GUIDE_PURCHASE_MONEY = "구입금액을 입력해 주세요.";

    private static final Scanner in = new Scanner(System.in);

    private static String nextLine() {
        return in.nextLine();
    }

    public String requestPurchasedLotto() {
        System.out.println(GUIDE_PURCHASE_MONEY);
        return in.nextLine();
    }

    public String requestManual() {
        System.out.println(GUIDE_MANUAL_LOTTO_COUNT);
        return in.nextLine();
    }

    public String requestWinningNumbers() {
        System.out.println(GUIDE_LAST_WEEK_WINNING_NUMBER);
        return in.nextLine();
    }

    public String requestBonusNumber() {
        System.out.println(GUIDE_INPUT_BONUS_NUMBER);
        return in.nextLine();
    }

    public List<Set<Integer>> makeManualLottoNumbers(final String manualCount) {
        System.out.println(GUIDE_MANUAL_NUMBERS);
        return IntStream.rangeClosed(1, Integer.parseInt(manualCount))
                .mapToObj(i -> nextLine())
                .map(this::apply)
                .collect(toList());
    }

    private Set<Integer> apply(String lottoNumbers) {
        return Arrays.stream(lottoNumbers.split(SPLIT_DELIMITER))
                .map(Integer::new)
                .collect(toSet());
    }
}
