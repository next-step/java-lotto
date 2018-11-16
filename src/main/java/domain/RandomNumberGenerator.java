package domain;

import util.CollectionCast;

import java.util.*;

import static domain.LottoNo.MAX_NUMBER;
import static domain.LottoNo.MIN_NUMBER;
import static util.CollectionCast.*;

public class RandomNumberGenerator implements NumberGenerator {

    public static final int LOTTO_DIGITS = 6;

    @Override
    public Map<Integer, LottoNo> getRandomNumber() {
        List<LottoNo> initNumbers = initNumbers();
        shuffleNumbers(initNumbers);

        List<LottoNo> attemptNumbers = initNumbers.subList(0, LOTTO_DIGITS);
        sortNumbers(attemptNumbers);

        Map<Integer, LottoNo> integerLottoNoMap = changeListToMap(attemptNumbers);
        return integerLottoNoMap;
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
