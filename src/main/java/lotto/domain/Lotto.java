package lotto.domain;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private static final int DEFAULT_SIZE = 6;
    public static final int LOTTO_MAX_NUM = 45;
    public static final int LOTTO_MIN_NUM = 1;

    private final Set<Integer> lottoNums;

    private static final List<Integer> NUMBERS = IntStream.rangeClosed(LOTTO_MIN_NUM, LOTTO_MAX_NUM)
            .boxed()
            .collect(Collectors.toList());

    public Lotto(Set<Integer> lottoNums) {
        if(lottoNums.size() != DEFAULT_SIZE) {
            throw new IllegalArgumentException("lotto input has wrong size");
        }
        this.lottoNums = new TreeSet<>(lottoNums);
    }

    public boolean hasSameElement(Integer number){
        return lottoNums.contains(number);
    }

    public Set<Integer> getLottoNums() {
        return lottoNums;
    }

    @Override
    public String toString() {
        return lottoNums.toString();
    }

    public int getSameElementsSize(Lotto winningLottoNumbers){
        return (int) lottoNums.stream()
                .filter(winningLottoNumbers::hasSameElement)
                .count();
    }

    public static Lotto generateRandomLotto() {
        Collections.shuffle(NUMBERS);
        return new Lotto(new TreeSet<>(NUMBERS.subList(0, 6)));
    }
}
