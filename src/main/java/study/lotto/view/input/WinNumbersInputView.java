package study.lotto.view.input;

import study.lotto.core.LottoNumber;
import study.lotto.core.WinLottoNumbers;
import study.lotto.dispenser.LottoDispenser;
import study.lotto.utils.Utils;
import study.lotto.view.AbstractView;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

public class WinNumbersInputView extends AbstractView {

    private static Scanner scanner = Utils.newScanner();
    private static final String WIN_LOTTO_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";

    private WinNumbersInputView() {}

    private static void displayWinLottoNumbersMessage() {
        stringBuilder.append(WIN_LOTTO_NUMBERS_MESSAGE);
        printAndClear();
    }

    public static List<String> getWinLottoNumbersInput() {
        displayWinLottoNumbersMessage();

        return parseForLottoNumber(scanner.nextLine());
    }

    private static void displayBonusLottoNumberMessage() {
        stringBuilder.append(BONUS_NUMBER_MESSAGE);
        printAndClear();
    }

    public static String getBonusLottoNumberInput() {
        displayBonusLottoNumberMessage();
        return scanner.nextLine();
    }

}
