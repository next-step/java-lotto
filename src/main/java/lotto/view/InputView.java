package lotto.view;

import lotto.domain.LottoNumbers;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static long inputPriceForBuying() {
        System.out.println("구입금액을 입력해주세요.");
        return SCANNER.nextLong();
    }

    public static String inputLastWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.next();
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static long inputManualLottoCounts() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return SCANNER.nextLong();
    }

    public static List<LottoNumbers> inputManualNumbers(long manualCounts) {
        System.out.println("수동으로 구매할 번호를 입력해주세요.");
        return Stream.generate(SCANNER::next)
                    .limit(manualCounts)
                    .map(LottoNumbers::valueOf)
                    .collect(Collectors.toList());
    }
}
