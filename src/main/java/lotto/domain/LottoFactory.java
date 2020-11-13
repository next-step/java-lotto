package lotto.domain;

import lotto.utils.Splitter;
import lotto.utils.validator.LottoValidator;

import java.util.List;

public class LottoFactory {
    private LottoFactory() {}

    public static Lotto createLottoFromIntList(List<Integer> lottoNos) {
        LottoValidator.validateLottoNoIntList(lottoNos);
        Lotto lotto = new Lotto();
        for (int no : lottoNos) {
            lotto.add(no);
        }
        return lotto;
    }

    public static Lotto createLottoFromStrList(List<String> lottoNos) {
        LottoValidator.validateLottoNoStrList(lottoNos);
        Lotto lotto = new Lotto();
        for (String no : lottoNos) {
            lotto.add(no);
        }
        return lotto;
    }

    public static Lotto createLotto(String lottoStr) {
        LottoValidator.validateLottoStr(lottoStr);
        return createLottoFromStrList(Splitter.splitLottoStr(lottoStr));
    }
}
