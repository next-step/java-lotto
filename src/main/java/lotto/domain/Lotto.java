package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> lotto;

    public Lotto(List<LottoNumber> lotto) {

        if (lotto.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
        this.lotto = lotto;
    }

    public static Lotto of(List<Integer> lottoIntList) {

        return new Lotto(lottoIntList.stream()
                .map(integer -> LottoNumber.of(integer))
                .collect(Collectors.toList()));
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    public List<LottoNumber> getLotto() {
        return lotto;
    }

    public List<Integer> getLottoIntegerList() {

        List<Integer> lottoIntegerList = new ArrayList<>();
        for (LottoNumber lottoNumber : lotto) {
            lottoIntegerList.add(lottoNumber.getNo());
        }
        return lottoIntegerList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }
}
