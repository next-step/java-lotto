package study.lotto.view.input;

import study.lotto.core.LottoNumber;
import study.lotto.core.WinLottoNumbers;
import study.lotto.dispenser.LottoDispenser;
import study.lotto.utils.Utils;
import study.lotto.view.AbstractView;

import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

public class WinNumbersInputView extends AbstractView {

    private static Scanner scanner = Utils.newScanner();
    private static final String WIN_LOTTO_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";

    private WinNumbersInputView() {}

    public static WinLottoNumbers display() {
        Set<LottoNumber> lottoNumbers = winningLottoNumbersView();

        WinLottoNumbers.WinLottoNumbersBuilder builder = new WinLottoNumbers.WinLottoNumbersBuilder(lottoNumbers);

        Optional.ofNullable(bonusLottoNumberView())
                .ifPresent(builder::bonusLottoNumber);

        return builder.build();
    }

    private static Set<LottoNumber> winningLottoNumbersView() {
        stringBuilder.append(WIN_LOTTO_NUMBERS_MESSAGE);
        printAndClear();

        String winLottoNumbers = scanner.nextLine();

        return LottoDispenser.toLottoNumbers(parseForLottoNumber(winLottoNumbers));
    }

    private static LottoNumber bonusLottoNumberView() {
        stringBuilder.append(BONUS_NUMBER_MESSAGE);
        printAndClear();

        String bonusLottoNumber = scanner.nextLine();
        return LottoNumber.of(bonusLottoNumber);
    }

}
