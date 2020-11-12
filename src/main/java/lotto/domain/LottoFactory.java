package lotto.domain;

import lotto.asset.LottoConst;
import lotto.utils.validator.LottoValidator;

public class LottoFactory {
    private LottoFactory() {}

    public static Lotto createLotto(Integer[] lottoNoArr) {
        LottoValidator.validateLottoNoArr(lottoNoArr);
        Lotto lotto = new Lotto();
        for (int no : lottoNoArr) {
            lotto.add(no);
        }
        return lotto;
    }

    public static Lotto createLotto(String[] lottoNoArr) {
        LottoValidator.validateLottoNoArr(lottoNoArr);
        Lotto lotto = new Lotto();
        for (String no : lottoNoArr) {
            lotto.add(no);
        }
        return lotto;
    }

    public static Lotto createLotto(String lottoStr) {
        LottoValidator.validateLottoStr(lottoStr);
        String[] lottoNoArr = lottoStr.split(LottoConst.splitRegex);
        return createLotto(lottoNoArr);
    }
}
