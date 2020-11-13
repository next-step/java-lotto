package lotto.domain;

import lotto.utils.Splitter;
import lotto.utils.validator.LottoValidator;

import java.util.List;

public class LottoFactory {
    private LottoFactory() {}

    public static Lotto createLottoFromIntList(List<Integer> lottoNoArr) {
        LottoValidator.validateLottoNoIntList(lottoNoArr);
        Lotto lotto = new Lotto();
        for (int no : lottoNoArr) {
            lotto.add(no);
        }
        return lotto;
    }

    public static Lotto createLottoFromStrList(List<String> lottoNoArr) {
        LottoValidator.validateLottoNoStrList(lottoNoArr);
        Lotto lotto = new Lotto();
        for (String no : lottoNoArr) {
            lotto.add(no);
        }
        return lotto;
    }

    public static Lotto createLotto(String lottoStr) {
        LottoValidator.validateLottoStr(lottoStr);
        return createLottoFromStrList(Splitter.splitLottoStr(lottoStr));
    }
}
