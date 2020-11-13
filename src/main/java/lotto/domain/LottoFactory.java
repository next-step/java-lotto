package lotto.domain;

import lotto.utils.Splitter;
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

    // FIXME: createLotto 오버로딩
    public static Lotto createLottoFromStrList(List<String> lottoNos) {
        LottoValidator.validateLottoNoStrList(lottoNos);
        Lotto lotto = new Lotto();
        for (String no : lottoNos) {
            lotto.add(no);
        }
        return lotto;
    }

    public static Lotto createLotto(String lottoStr) {
        return createLottoFromStrList(
                Splitter.splitLottoStr(lottoStr)
        );
    }
}
