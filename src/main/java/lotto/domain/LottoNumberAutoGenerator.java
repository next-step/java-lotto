package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.domain.LottoOptions.*;

/**
 * 로또 번호를 랜덤으로 생성
 */
public final class LottoNumberAutoGenerator {
    private static final List<LottoNumber> NUMBER_BOX = new ArrayList<>(MAX_NUMBER);

    static {
        for (int i = MIN_NUMBER; i < MAX_NUMBER; i++) {
            NUMBER_BOX.add(new LottoNumber(i));
        }
    }

    private LottoNumberAutoGenerator() {
    }

    public static List<LottoNumber> drawLots() {
        Collections.shuffle(NUMBER_BOX);
        return NUMBER_BOX.subList(0, LOTTO_SIZE);
    }
}
