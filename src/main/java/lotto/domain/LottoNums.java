package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNums {

    private static final int LOTTO_COUNT = 6;

    private List<LottoNum> lottoNums;

    public LottoNums(List<LottoNum> lottoNums) {
        validate(lottoNums);
        this.lottoNums = lottoNums;
    }

    public int getMatchCount(LottoNums targetNums) {
        return (int) this.lottoNums.stream()
            .filter(num -> targetNums.contain(num))
            .count();
    }

    private void validate(List<LottoNum> lottoNums) {
        if (lottoNums.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("lotto has only six nums");
        }

        if (lottoNums.stream().distinct().count() != LOTTO_COUNT) {
            throw new IllegalArgumentException("Lotto numbers must be unique");
        }
    }

    private boolean contain(LottoNum object) {
        return this.lottoNums.contains(object);
    }

    List<Integer> toList() {
        return this.lottoNums.stream().map(LottoNum::getVal).collect(Collectors.toList());
    }
}
