package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberRandomGenerator implements LottoNumberGenerator {

    private final List<LottoNumber> allLottoNumbers;

    public LottoNumberRandomGenerator() {
        allLottoNumbers = new ArrayList<>();

        for (int i = LottoConstants.LOTTO_MIN; i <= LottoConstants.LOTTO_MAX; i++) {
            allLottoNumbers.add(new LottoNumber(i));
        }
    }

    @Override
    public List<LottoNumber> getNumbers(int size) {
        mixNumbers();
        return allLottoNumbers.subList(0, LottoConstants.LOTTO_SIZE);
    }

    private void mixNumbers() {
        Collections.shuffle(allLottoNumbers);
    }
}
