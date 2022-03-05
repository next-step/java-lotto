package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;

public class KoreanRandomLottoCreator extends KoreanLottoCreator {
    @Override
    public Lotto createLotto() {
        Collections.shuffle(numberData);
        return new Lotto(new ArrayList<>(numberData.subList(0, Lotto.LOTTO_NUMBERS_SIZE)));
    }
}
