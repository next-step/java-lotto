package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    public static final int MIN_LOTTO_RANGE = 1;
    private static final int MAX_LOTTO_RANGE = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static List<Integer> lottoNumbers = new ArrayList<>();

    static {
        IntStream.rangeClosed(MIN_LOTTO_RANGE, MAX_LOTTO_RANGE)
            .forEach(i -> lottoNumbers.add(i));
    }

    private Lotto(){
        generateAutoLottoNumber();
    }

    private void generateAutoLottoNumber() {
        Collections.shuffle(lottoNumbers);

        lottoNumbers = lottoNumbers.stream()
            .limit(LOTTO_NUMBER_COUNT)
            .sorted()
            .collect(Collectors.toList());
    }

    public static Lotto newAutoLottoInstance() {
        return new Lotto();
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
