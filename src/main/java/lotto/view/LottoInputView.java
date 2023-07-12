package lotto.view;

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

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(SCANNER.nextLine());
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Arrays.stream(SCANNER.nextLine().split(","))
                .map(number -> Integer.parseInt(number.trim()))
                .collect(Collectors.toUnmodifiableList());
    }

    public int inputBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(SCANNER.nextLine());
    }
}
