package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLotto {

    public static final int MIN_LOTTO_RANGE = 1;
    private static final int MAX_LOTTO_RANGE = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static List<Integer> lottoNumbers = new ArrayList<>();

    private AutoLotto(){
        IntStream.rangeClosed(MIN_LOTTO_RANGE, MAX_LOTTO_RANGE)
            .forEach(i -> lottoNumbers.add(i));

        Collections.shuffle(lottoNumbers);

        lottoNumbers = lottoNumbers.stream()
            .limit(LOTTO_NUMBER_COUNT)
            .sorted()
            .collect(Collectors.toList());
    }

    public static AutoLotto newAutoLottoInstance() {
        return new AutoLotto();
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
