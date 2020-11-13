package lotto.domain;

import lotto.utils.LottoParser;
import lotto.utils.validator.LottoValidator;

import java.util.List;

public class LottoFactory {
    private LottoFactory() {}

    public static Lotto createLotto(List<Integer> lottoNos) {
        LottoValidator.validateLottoNos(lottoNos);
        Lotto lotto = new Lotto();
        for (int no : lottoNos) {
            lotto.add(no);
        }
        return lotto;
    }

    public static Lotto createLotto(String lottoStr) {
        LottoValidator.validateLottoStr(lottoStr);
        return createLotto(
                LottoParser.parseLottoStr(lottoStr)
        );
    }
}
