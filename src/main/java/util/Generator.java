package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Generator {

    public static List<Integer> lottoNumbers() {
        return createLotto(initLottoNumbers(Constant.MIN_LOTTO_NUMBER, Constant.MAX_LOTTO_NUMBER));
    }

    private static List<Integer> initLottoNumbers(int minNumber, int maxNumber) {
        List<Integer> lottoNumbers = new ArrayList<>();
        IntStream.range(minNumber, maxNumber + 1).forEach(i -> lottoNumbers.add(i));
        Collections.shuffle(lottoNumbers);
        return lottoNumbers;
    }

    private static List<Integer> createLotto(List<Integer> lottoNumbers) {
        List<Integer> lotto = new ArrayList<>();
        IntStream.range(0, Constant.MAX_LOTTO_NUMBER_COUNT).forEach(i -> lotto.add(lottoNumbers.get(i)));
        Collections.sort(lotto);
        return lotto;
    }

}
