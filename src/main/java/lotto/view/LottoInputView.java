package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public final class LottoInputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private LottoInputView() {
    }

    private static class LottoInputViewHolder {

        private static final LottoInputView INSTANCE = new LottoInputView();

    }

    public static LottoInputView getInstance() {
        return LottoInputViewHolder.INSTANCE;
    }

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바르지 않은 입력입니다.");
        }
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요. ','로 구분하여 6개를 입력해주세요.");
        try {
            return Arrays.stream(SCANNER.nextLine().split(","))
                    .map(number -> Integer.parseInt(number.trim()))
                    .collect(Collectors.toUnmodifiableList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바르지 않은 입력입니다.");
        }
    }

    public int inputBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바르지 않은 입력입니다.");
        }
    }
}
