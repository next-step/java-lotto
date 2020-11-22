package study.lotto.view.input;

import study.lotto.core.LottoNumber;
import study.lotto.core.WinLottoNumbers;
import study.lotto.dispenser.LottoDispenser;
import study.lotto.utils.Utils;
import study.lotto.view.AbstractView;

import java.util.Scanner;
import java.util.Set;

public class WinNumbersInputView extends AbstractView {

    private static Scanner scanner = Utils.newScanner();

    private WinNumbersInputView() {}

    public static WinLottoNumbers display() {
        return new WinLottoNumbers(winningLottoNumbersView(), bonusLottoNumberView());
    }

    private static Set<LottoNumber> winningLottoNumbersView() {
        stringBuilder.append("지난 주 당첨 번호를 입력해 주세요.");
        printAndClear();

        String winLottoNumbers = scanner.nextLine();

        return LottoDispenser.toLottoNumbers(parseForLottoNumber(winLottoNumbers));
    }

    private static LottoNumber bonusLottoNumberView() {
        stringBuilder.append("보너스 볼을 입력해 주세요.");
        printAndClear();

        String bonusLottoNumber = scanner.nextLine();
        return LottoNumber.of(bonusLottoNumber);
    }

}
