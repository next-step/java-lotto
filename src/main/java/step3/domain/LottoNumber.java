package step3.domain;

import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class LottoNumber {

    public static final int LOTTO_MAX_LIMIT = 45;
    public static final int LOTTO_DRAW_LIMIT = 6;
    public static final int LOTTO_DRAW_BASE_NUMBER = 0;
    public static final String FIXED_DELIMITER = ",|:";

    public static void checkLottoRules(TreeSet<Integer> lottoNumbers) {
        if (Collections.max(lottoNumbers) > LOTTO_MAX_LIMIT) {
            throw new IllegalArgumentException();
        }
        if (lottoNumbers.size() != LOTTO_DRAW_LIMIT) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkLottoRules(TreeSet<Integer> lottoNumbers, int bonusNumber) {
        LottoNumber.checkLottoRules(lottoNumbers);
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> drawLottoNumbers(List<Integer> lottoNumbers) {
        return lottoNumbers.subList(LOTTO_DRAW_BASE_NUMBER, LOTTO_DRAW_LIMIT);
    }

}
