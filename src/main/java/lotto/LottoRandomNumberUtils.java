package lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoRandomNumberUtils implements LottoRandomNumber {
    private static final List<Integer> LOTTO_NUMBER_RANGE = LottoValidationUtils.lottoNumberRange();

    public LottoNumber createRandomLotto() {
        List<Integer> randomNumber = new ArrayList<>();
        Collections.shuffle(LOTTO_NUMBER_RANGE);
        for (int number = 0; number < LottoValidationUtils.getLottoNumberSize() ; number++) {
            randomNumber.add(LOTTO_NUMBER_RANGE.get(number));
        }
        Collections.sort(randomNumber);
        return new LottoNumber(randomNumber);
    }
}
