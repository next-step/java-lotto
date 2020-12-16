package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoNumberGenerateStrategy implements LottoNumberGenerateStrategy {
    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;
    public static final int PICK_START = 0;
    public static final int PICK_END = 6;

    private List<LottoNumber> numberCards;

    public AutoLottoNumberGenerateStrategy() {
        this.numberCards = new ArrayList<>();
        for (int i = LOTTO_MIN; i <= LOTTO_MAX; i++) {
            numberCards.add(LottoNumber.of(i));
        }
    }

    @Override
    public LottoNumbers generateLottoNumbers() {
        Collections.shuffle(numberCards);
        List<LottoNumber> picked = numberCards.subList(PICK_START, PICK_END);
        Collections.sort(picked);
        return new LottoNumbers(picked);
    }

}

