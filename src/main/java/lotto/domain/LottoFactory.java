package lotto.domain;

import lotto.asset.LottoConst;
import lotto.exception.BadNumOfLottoNoException;

import java.util.List;

public class LottoFactory {
    private LottoFactory() {}

    public static Lotto createLotto(List<Integer> lottoNos) {
        validateLottoNos(lottoNos);
        Lotto lotto = new Lotto();
        for (int no : lottoNos) {
            lotto.add(no);
        }
        return lotto;
    }

    public static Lotto createLotto(String lottoStr) {
        return createLotto(
                LottoParser.parseLottoStr(lottoStr)
        );
    }

    private static void validateLottoNos(List<Integer> lottoNos) {
        if (lottoNos.size() != LottoConst.NUM_OF_LOTTO_NO) {
            throw BadNumOfLottoNoException.getInstance();
        }
    }
}
