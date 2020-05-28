package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final int COUNT_OF_LOTTO_NUMBER = 6;
    private final List<LottoNumber> lottoNumberList;

    private Lotto(List<LottoNumber> lottoNumberList) {
        this.lottoNumberList = new ArrayList<>();
        for (LottoNumber lottoNumber : lottoNumberList) {
            if (this.lottoNumberList.contains(lottoNumber)) {
                throw new IllegalArgumentException("`lottoNumber` is must not be duplicated");
            }
            this.lottoNumberList.add(lottoNumber);
        }
    }

    public static Lotto generateByManual(List<Integer> numberList) {
        return new Lotto(numberList.stream().map(LottoNumber::generateByManual).collect(Collectors.toList()));
    }

    public static Lotto generateByAuto() {
        List<LottoNumber> lottoNumberList = IntStream.range(0, COUNT_OF_LOTTO_NUMBER).mapToObj(i -> LottoNumber.generateByAuto()).collect(Collectors.toList());
        try {
            return new Lotto(lottoNumberList);
        } catch (IllegalArgumentException e) {
            return generateByAuto();
        }
    }

    public List<LottoNumber> getLottoNumberList() {
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
