package lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomPicker {
    private final static int LOTTO_MIN_NUMBER = 1;
    public final static int LOTTO_MAX_NUMBER = 45;
    private final List<Integer> lottoAllNumbers = new ArrayList<>();

    public RandomPicker() {
        IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER).forEach(lottoAllNumbers::add);
    }

    public Set<Integer> pickRandomLotto() {
        Collections.shuffle(lottoAllNumbers);
        List<Integer> lottoNumbers = lottoAllNumbers.stream().limit(6).collect(Collectors.toList());
        return new TreeSet<>(lottoNumbers);
    }
}
