package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public final class LottoInputView {

    private static final LottoInputView INSTANCE = new LottoInputView();
    private static final Scanner SCANNER = new Scanner(System.in);

    private LottoInputView() {
    }

    public static LottoInputView getInstance() {
        return INSTANCE;
    }

    public long inputPurchase() {
        System.out.println("구입금액을 입력해 주세요.");
        return Long.parseLong(SCANNER.nextLine());
    }

    public long inputManualLottosSize() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Long.parseLong(SCANNER.nextLine());
    }

    public List<List<Integer>> inputManualLottosNumbers(long count) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        final List<List<Integer>> manualLottosNumbers = new ArrayList<>();
        for (long current = 0; current < count; current++) {
            manualLottosNumbers.add(convertToNumbers());
        }
        return manualLottosNumbers;
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return convertToNumbers();
    }

    public int inputBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(SCANNER.nextLine());
    }

    private static List<Integer> convertToNumbers() {
        return Arrays.stream(SCANNER.nextLine().split(","))
                .map(number -> Integer.parseInt(number.trim()))
                .collect(Collectors.toUnmodifiableList());
    }
}
