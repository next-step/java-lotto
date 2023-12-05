package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;
    private static final String DELIMITER = ",";
    private final Set<LottoNumber> lottoNumbers;

    public LottoNumbers(String numebrs) {
        this.lottoNumbers = Arrays.stream(numebrs.split(DELIMITER))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public LottoNumbers(int... value) {
        this.lottoNumbers = Arrays.stream(value)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    public LottoNumbers() {
        this.lottoNumbers = generateLottoNumbers();
    }

    public Set<LottoNumber> generateLottoNumbers() {
        List<Integer> numberList = IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(numberList);

        return numberList.stream()
                .limit(LOTTO_COUNT)
                .map(LottoNumber::new)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
