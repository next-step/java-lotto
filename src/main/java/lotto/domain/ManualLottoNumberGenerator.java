package lotto.domain;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class ManualLottoNumberGenerator implements LottoNumberGenerator {
    private final static String INPUT_MANUAL_LOTTO_NUMBERS_MSG = "수동으로 구매할 번호를 입력하세요";

    private int count;

    public ManualLottoNumberGenerator(int count) {
        this.count = count;
    }

    @Override
    public List<LottoNumbers> generate() {
        OutputView.printMsg(INPUT_MANUAL_LOTTO_NUMBERS_MSG);
        return InputView.inputManualLottoNumbers(count);
    }
}
