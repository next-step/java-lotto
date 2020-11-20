package study.lotto.view.input;

import study.lotto.core.LottoNumber;
import study.lotto.core.WinLottoNumbers;
import study.lotto.view.AbstractView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinNumbersInputView extends AbstractView {

    private static final WinNumbersInputView instance = new WinNumbersInputView();

    public static WinNumbersInputView getInstance() {
        return instance;
    }

    public WinLottoNumbers display() {
        return new WinLottoNumbers(winningLottoNumbersView(), bonusLottoNumberView());
    }

    private List<LottoNumber> winningLottoNumbersView() {
        stringBuilder.append("지난 주 당첨 번호를 입력해 주세요.");
        printAndClear();

        String winLottoNumbers = scanner.nextLine();

        return createLottoNumber(winLottoNumbers);
    }

    private LottoNumber bonusLottoNumberView() {
        stringBuilder.append("보너스 볼을 입력해 주세요.");
        printAndClear();

        String bonusLottoNumber = scanner.nextLine();
        return LottoNumber.of(bonusLottoNumber);
    }

}
