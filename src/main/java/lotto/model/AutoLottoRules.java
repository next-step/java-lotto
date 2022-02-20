package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoRules {

    private final static int START_NUM = 1;
    private final static int LAST_NUM = 45;
    private final static int START_INDEX = 0;
    private final static int LAST_INDEX = 6;

    private final List<LottoNumber> initialLottoNumbers;

    public AutoLottoRules() {
        initialLottoNumbers = new ArrayList<>();
        for (int i = START_NUM; i <= LAST_NUM; i++) {
            initialLottoNumbers.add(new LottoNumber(i));
        }
    }

    public List<LottoNumber> makeLottoNumbers() {
        Collections.shuffle(initialLottoNumbers);
        return new ArrayList<>(initialLottoNumbers.subList(START_INDEX, LAST_INDEX));
    }

}
