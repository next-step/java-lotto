package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;

import static domain.LottoNo.MAX_NUMBER;
import static domain.LottoNo.MIN_NUMBER;

public class RandomNumberGenerator implements NumberGenerator {

    public static final int LOTTO_DIGITS = 6;

    List<LottoNo> initNumbers;

    public RandomNumberGenerator() {
        if(initNumbers == null)
        initNumbers = new ArrayList<>();
    }

    @Override
    public List<LottoNo> getRandomNumber() {
        List<LottoNo> initNumbers = initNumbers();
        shuffleNumbers(initNumbers);

        List<LottoNo> attemptNumbers = initNumbers.subList(0, LOTTO_DIGITS);
        sortNumbers(attemptNumbers);

        return attemptNumbers;
    }

    private void sortNumbers(List<LottoNo> lottoNos) {
        lottoNos.sort(Comparator.comparingInt(LottoNo::getNumber));
    }

    private void shuffleNumbers(List<LottoNo> lottoNos) {
        Collections.shuffle(lottoNos);
    }

    private List<LottoNo> initNumbers() {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            initNumbers.add(new LottoNo(i));
        }
        return initNumbers;
    }
}
