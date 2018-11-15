package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;

public class RandomNumberGenerator implements NumberGenerator {

    public static final int DIGITS = 6;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    @Override
    public List<LottoNo> getRandomNumber() {
        List<LottoNo> initNumbers = initNumbers();
        shuffleNumbers(initNumbers);

        List<LottoNo> attemptNumbers = initNumbers.subList(0, DIGITS);
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
        List<LottoNo> initNumbers = new ArrayList<>();
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            initNumbers.add(new LottoNo(i));
        }
        return initNumbers;
    }
}
