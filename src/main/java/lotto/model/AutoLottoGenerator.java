package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoGenerator implements LottoGenerator {

    private final static int START_INDEX = 0;
    private final static int LAST_INDEX = 6;

    private final List<LottoNumber> initialLottoNumbers;

    public AutoLottoGenerator() {
        initialLottoNumbers = new ArrayList<>();
        for (int i = START_NUM; i <= LAST_NUM; i++) {
            initialLottoNumbers.add(new LottoNumber(i));
        }
    }

    @Override
    public List<LottoNumber> generateLotto() {
        Collections.shuffle(initialLottoNumbers);
        List<LottoNumber> lottoNumbers = new ArrayList<>(
            initialLottoNumbers.subList(START_INDEX, LAST_INDEX));
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
