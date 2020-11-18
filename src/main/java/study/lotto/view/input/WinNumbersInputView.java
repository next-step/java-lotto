package study.lotto.view.input;

import study.lotto.core.LottoNumber;
import study.lotto.core.WinLottoNumbers;
import study.lotto.view.AbstractView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinNumbersInputView extends AbstractView {

    private static final WinNumbersInputView instance = new WinNumbersInputView();
    private static final String DELIMITER = ",";

    public static WinNumbersInputView getInstance() {
        return instance;
    }

    public WinLottoNumbers display() {
        stringBuilder.append("지난 주 당첨 번호를 입력해 주세요.");
        printAndClear();

        String winLottoNumbers = scanner.nextLine();

        List<LottoNumber> lottoNumbers =
                Arrays.asList(winLottoNumbers.split(DELIMITER))
                    .stream()
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .map(LottoNumber::new)
                    .collect(Collectors.toList());

        return new WinLottoNumbers(lottoNumbers);

    }

}
