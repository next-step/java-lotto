package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Collections.shuffle;
import static lotto.domain.LottoGame.LOTTO_NUMBER_COUNT;
import static lotto.domain.LottoNumber.*;

public class LottoGameAutoGenerator implements LottoGameGenerator {
    private List<LottoNumber> randomLottoNumbers;

    public LottoGameAutoGenerator() {
        createRandomLottoNumbers();
    }

    public LottoGame generate() {
        shuffle(randomLottoNumbers);
        Set<LottoNumber> values = new HashSet<>();

        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            values.add(randomLottoNumbers.get(i));
        }

        return new LottoGame(values);
    }

    private void createRandomLottoNumbers() {
        randomLottoNumbers = new ArrayList<>();

        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            randomLottoNumbers.add(from(i));
        }
    }
}
