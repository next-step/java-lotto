package lotto.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lotto.domain.Lotto;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private static final String PURCHASE_PRICE_QUESTION = "구입금액을 입력해 주세요.";
    private static final String WINNING_LOTTO_NUMBER_QUESTION = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_QUESTION = "보너스 볼을 입력해 주세요.";
    private static final String MANUAL_LOTTO_COUNT_QUESTION = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_NUMBER_QUESTION = "수동으로 구매할 번호를 입력해 주세요.";

    private InputView() {
        throw new UnsupportedOperationException("유틸형 클래스는 생성할 수 없습니다");
    }

    public static String readPurchasePrice() {
        System.out.println(PURCHASE_PRICE_QUESTION);
        return SCANNER.nextLine();
    }

    private static void printBlankLine() {
        System.out.println();
    }

    public static String readWinningLottoNumber() {
        printBlankLine();
        System.out.println(WINNING_LOTTO_NUMBER_QUESTION);
        return SCANNER.nextLine();
    }

    public static int readBonusNumber() {
        System.out.println(BONUS_NUMBER_QUESTION);
        return SCANNER.nextInt();
    }

    public static List<String> readManualLottoNumbers() {
        int manualLottoCount = readManualLottoCount();
        return readLottoNumbers(manualLottoCount);
    }

    private static int readManualLottoCount() {
        printBlankLine();
        System.out.println(MANUAL_LOTTO_COUNT_QUESTION);
        return SCANNER.nextInt();
    }

    private static List<String> readLottoNumbers(int count) {
        List<String> lottoNumbers = new ArrayList<>();
        printBlankLine();
        System.out.println(MANUAL_LOTTO_NUMBER_QUESTION);
        SCANNER.nextLine();
        for (int i = 0; i < count; i++) {
            lottoNumbers.add(SCANNER.nextLine());
        }
        return lottoNumbers;
    }
}
