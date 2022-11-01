package lotto.domain;

import lotto.strategy.LottoGenerateStrategy;
import lotto.util.StringUtils;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoNumber.LOTTO_MAX_NUM;
import static lotto.domain.LottoNumber.LOTTO_MIN_NUM;

public class Lotto {

    public static final List<LottoNumber> LOTTO_NUMBERS = IntStream.rangeClosed(LOTTO_MIN_NUM, LOTTO_MAX_NUM)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());
    private static final int DEFAULT_SIZE = 6;

    private final Set<LottoNumber> lottoNums;

    public Lotto(Set<LottoNumber> lottoNums) {
        if (lottoNums.size() != DEFAULT_SIZE) {
            throw new IllegalArgumentException("lotto input has wrong size");
        }
        this.lottoNums = new TreeSet<>(lottoNums);
    }

    public Lotto(LottoGenerateStrategy lottoGenerateStrategy) {
        this(lottoGenerateStrategy.generateLotto());
    }

    public boolean hasSameElement(LottoNumber lottoNumber) {
        return lottoNums.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return lottoNums.toString();
    }

    public int getSameElementsSize(Lotto winningLottoNumbers) {
        return (int) lottoNums.stream()
                .filter(winningLottoNumbers::hasSameElement)
                .count();
    }

    public static Lotto from(Set<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers.stream().map(LottoNumber::new).collect(Collectors.toSet()));
    }

    public static Lotto from(String lottoNumbers) {
        return from(StringUtils.refineNumbers(lottoNumbers));
    }
}
