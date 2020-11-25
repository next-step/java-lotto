package study.lotto.view.input;

import study.lotto.core.Lotto;
import study.lotto.dispenser.LottoDispenser;
import study.lotto.dispenser.Lottos;
import study.lotto.utils.Utils;
import study.lotto.view.AbstractView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManualLottoInputView extends AbstractView {

    private static Scanner scanner = Utils.newScanner();
    private static final String MANUAL_LOTTO_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";

    private ManualLottoInputView() {}

    public static void displayMessage() {
        stringBuilder.append(MANUAL_LOTTO_NUMBERS_MESSAGE);
        printAndClear();
    }

    public static List<String> getInput() {
        return parseForLottoNumber(scanner.nextLine());
    }

}

