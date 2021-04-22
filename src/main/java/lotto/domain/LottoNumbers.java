package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {

    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private List<Integer> lottoNumbers = new ArrayList<>();

    public LottoNumbers() {
        IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
                    .forEach(lottoNumbers::add);
    }

    public List<Integer> generateLottoNumbers() {
        Collections.shuffle(lottoNumbers);
        return generateShuffleNumber();
    }

    public List<Integer> generateShuffleNumber() {
        return lottoNumbers.stream()
                .limit(LOTTO_NUMBER_COUNT)
                .collect(Collectors.toList());
    }

    public int lottoNumbersCount() {
        return lottoNumbers.size();
    }
}
