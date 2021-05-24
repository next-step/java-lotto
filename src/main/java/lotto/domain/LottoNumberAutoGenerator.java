package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.domain.LottoOptions.*;

/**
 * 로또 번호를 랜덤으로 생성
 */
public final class LottoNumberAutoGenerator implements LottoNumberGenerator {
    private final List<LottoNumber> numberBox = new ArrayList<>(MAX_NUMBER);

    public LottoNumberAutoGenerator() {
        for (int i = MIN_NUMBER; i < MAX_NUMBER; i++) {
            numberBox.add(new LottoNumber(i));
        }
    }

    @Override
    public List<LottoNumber> drawLots() {
        Collections.shuffle(numberBox);
        return numberBox.subList(0, LOTTO_SIZE);
    }
}
