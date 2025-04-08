package lotto.domain.generator;

import lotto.domain.model.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.constant.LottoConstants.*;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {
    private static final List<LottoNumber> CACHED_NUMBERS = new ArrayList<>();
    static {
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            CACHED_NUMBERS.add(new LottoNumber(i));
        }
    }

    @Override
    public List<LottoNumber> generate()  {
        List<LottoNumber> allNumbers = new ArrayList<>(CACHED_NUMBERS);
        Collections.shuffle(allNumbers);
        List<LottoNumber> lottoNumbers = allNumbers.subList(0, LOTTO_NUMBER_COUNT);
        return new ArrayList<>(lottoNumbers);
    }
}
