package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomPicker {
    private final static int LOTTO_MIN_NUMBER = 1;
    private final static int LOTTO_MAX_NUMBER = 45;
    private final List<Integer> lottoAllNumbers = new ArrayList<>();

    public RandomPicker() {
        IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER).forEach(lottoAllNumbers::add);
    }

    public List<Integer> pickRandomLotto() {
        Collections.shuffle(lottoAllNumbers);
        List<Integer> lottoNumbers = lottoAllNumbers.stream().limit(6).collect(Collectors.toList());
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
