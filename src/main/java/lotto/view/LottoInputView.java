package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-07 00:25
 */
public class LottoInputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String BLANK = " ";
    private static final String EMPTY = "";
    private static final Pattern NUMERIC = Pattern.compile("^[0-9]+$");

    public static final int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        final String amount = scanner.nextLine();

        if (!isNumeric(amount)) {
            throw new IllegalArgumentException("숫자만 입력이 가능합니다.");
        }

        return Integer.parseInt(amount);
    }

    public static final String inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        return scanner.nextLine().replaceAll(BLANK, EMPTY);
    }

    public static final int inputPurchaseManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        final String count = scanner.nextLine();

        if (!isNumeric(count)) {
            throw new IllegalArgumentException("숫자만 입력이 가능합니다.");
        }
        return Integer.parseInt(count);
    }

    public static final int inputBonusNo() {
        System.out.println("보너스 볼을 입력해 주세요.");
        final String bonusNo = scanner.nextLine();

        if (!isNumeric(bonusNo)) {
            throw new IllegalArgumentException("숫자만 입력이 가능합니다.");
        }
        return Integer.parseInt(bonusNo);
    }

    public static final List<String> inputPurchaseManualLotto(int lottoManualCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        List<String> manualLottoNumbers = new ArrayList<>();
        for (int count = 0; count < lottoManualCount; count++) {
            final String numbers = scanner.nextLine().replaceAll(BLANK, EMPTY);
            manualLottoNumbers.add(numbers);
        }

        return manualLottoNumbers;
    }

    private static boolean isNumeric(String amount) {
        return NUMERIC.matcher(amount).matches();
    }
}
