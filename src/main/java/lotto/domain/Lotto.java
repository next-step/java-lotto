package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int COUNT_OF_LOTTO_NUMBER = 6;
    private static final List<Integer> LOTTO_NUMBER_LIST = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER).boxed().collect(Collectors.toList());
    private final List<Integer> lottoNumberList;

    private Lotto(List<Integer> lottoNumberList) {
        this.lottoNumberList = new ArrayList<>();
        for (Integer lottoNumber : lottoNumberList) {
            if (this.lottoNumberList.contains(lottoNumber)) {
                throw new IllegalArgumentException("`lottoNumber` is must not be duplicated");
            }
            if (!LOTTO_NUMBER_LIST.contains(lottoNumber)) {
                throw new IllegalArgumentException(String.format("`number` is must be %d ~ %d", MIN_NUMBER, MAX_NUMBER));
            }
            this.lottoNumberList.add(lottoNumber);
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

    public List<Integer> getLottoNumberList() {
        return lottoNumberList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumberList, lotto.lottoNumberList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumberList);
    }
}
