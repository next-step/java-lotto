package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LottoFactory {
    private final static int NUMBER_COUNT = 6;
    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 10;
    private static final List<LottoNumber> lottoNumbers = lottoAllNumbers();

    private static List<LottoNumber> lottoAllNumbers() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }

        return lottoNumbers;
    }

    public static List<LottoNumber> createLotto() {
        List<LottoNumber> randomLottoNumbers = sortedRandomNumbers();
        return Collections.unmodifiableList(randomLottoNumbers);
    }

    private static List<LottoNumber> sortedRandomNumbers() {
        Collections.shuffle(LottoFactory.lottoNumbers);
        List<LottoNumber> randomLottoNumbers = new ArrayList<>();
        for(int i = 0; i < NUMBER_COUNT; i++) {
            randomLottoNumbers.add(LottoFactory.lottoNumbers.get(i));
        }

        randomLottoNumbers.sort(Comparator.comparingInt(LottoNumber::lottoNumber));

        return randomLottoNumbers;
    }
}
