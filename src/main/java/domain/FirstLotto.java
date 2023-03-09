package domain;

import java.util.ArrayList;
import java.util.List;

import view.InputView;

public class FirstLotto extends Lotto {
    private List<LottoNumber> lottoNumber;
    private LottoNumber bonusLottoNumber;

    void makeFirstLotto(List<String> input, String bonusLottoNumber) {
        validate(input);
        this.lottoNumber = makeLottoNumber(input);
        this.bonusLottoNumber = new LottoNumber(LottoUtil.stringToInteger(bonusLottoNumber));
    }

    public FirstLotto(String input, String bonusLottoNumber) {
        makeFirstLotto(LottoUtil.stringSplitToList(input), bonusLottoNumber);
    }
}
