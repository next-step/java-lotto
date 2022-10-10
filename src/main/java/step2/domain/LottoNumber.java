package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final int MIN_LOTTO_RANGE = 1;
    private static final int MAX_LOTTO_RANGE = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static List<Integer> lottoNumbersCache = new ArrayList<>();
    private final List<Integer> lottoNumbers = new ArrayList<>();

    static {
        IntStream.rangeClosed(MIN_LOTTO_RANGE, MAX_LOTTO_RANGE)
            .forEach(i -> lottoNumbersCache.add(i));
    }

    public static LottoNumber newInstance(){
        return new LottoNumber();
    }

    private LottoNumber(){
        generateLottoNumbers();
    }

    private void generateLottoNumbers() {
        Collections.shuffle(lottoNumbersCache);

        this.lottoNumbers.addAll(lottoNumbersCache.stream()
            .limit(LOTTO_NUMBER_COUNT)
            .sorted()
            .collect(Collectors.toList()));
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
