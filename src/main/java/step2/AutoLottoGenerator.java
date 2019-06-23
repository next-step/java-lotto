package step2;

import java.util.Collections;

public class AutoLottoGenerator extends LottoGenerator {

    @Override
    public Lotto generate() {
        Collections.shuffle(LOTTO_NUMBERS);
        return new Lotto(LOTTO_NUMBERS.subList(0, LOTTO_NUMBER_SIZE));
    }

}
