package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int COUNT_OF_LOTTO_NUMBER = 6;
    private static final List<Integer> LOTTO_NUMBER_LIST = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER).boxed().collect(Collectors.toList());
    private final Set<Integer> lottoNumberSet;

    private Lotto(List<Integer> lottoNumberSet) {
        this.lottoNumberSet = lottoNumberSet.stream().filter(LOTTO_NUMBER_LIST::contains).collect(Collectors.toSet());
        if (this.lottoNumberSet.size() != 6) {
            throw new IllegalArgumentException("`lottoNumber` is invalid");
        }
    }

    public static Lotto generateByManual(List<Integer> numberList) {
        return new Lotto(numberList);
    }

    public static Lotto generateByAuto() {
        Collections.shuffle(LOTTO_NUMBER_LIST);
        List<Integer> numberList = LOTTO_NUMBER_LIST.subList(0, COUNT_OF_LOTTO_NUMBER);
        return new Lotto(numberList);
    }

    public List<Integer> getLottoNumberSet() {
        return new ArrayList<>(lottoNumberSet);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumberSet, lotto.lottoNumberSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumberSet);
    }
}
