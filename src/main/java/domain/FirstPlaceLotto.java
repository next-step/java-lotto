package domain;

import java.util.ArrayList;
import java.util.List;

import view.InputView;

public class FirstPlaceLotto extends Lotto {
    private LottoNumbers lottoNumber;
    private LottoNumber bonusLottoNumber;

    void makeFirstLotto(List<String> input, String bonusLottoNumber) {
        this.lottoNumber = new LottoNumbers(input);
        this.bonusLottoNumber = new LottoNumber(LottoUtil.stringToInteger(bonusLottoNumber));
    }

    public FirstPlaceLotto(String input, String bonusLottoNumber) {
        makeFirstLotto(LottoUtil.stringSplitToList(input), bonusLottoNumber);
    }

    public LottoNumbers getLottoNumbers() {
        return this.lottoNumber;
    }

    public LottoNumber getBonusLottoNumber() {
        return this.bonusLottoNumber;
    }
}
