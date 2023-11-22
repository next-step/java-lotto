package com.fineroot.lotto.domain;

import com.fineroot.lotto.dto.WinningNumber;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    private final Set<LottoNumber> lottoNumberSet;

    private static final List<Integer> integerSet = Stream.iterate(1, i -> i + 1).limit(45)
            .collect(Collectors.toList());

    private Lotto(Set<LottoNumber> lottoNumberSet) {
        this.lottoNumberSet = lottoNumberSet;
    }

    public static Lotto from(Integer... numbers) {
        return new Lotto(Arrays.stream(numbers).map(LottoNumber::from).collect(Collectors.toSet()));
    }

    public static Lotto create() {
        return new Lotto(createLottoNumberSet());
    }

    private static Set<LottoNumber> createLottoNumberSet() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        Collections.shuffle(integerSet);
        for (Integer element : integerSet.stream().limit(6).collect(Collectors.toList())) {
            lottoNumbers.add(LottoNumber.from(element));
        }
        return lottoNumbers;
    }

    public WinningRank matchWithWinningNumber(WinningNumber lotto) {
        return WinningRank.of(
                (int) lottoNumberSet.stream().filter(lottoNumber -> lotto.getLottoNumbers().contains(lottoNumber))
                        .count());
    }

    @Override
    public String toString() {
        return lottoNumberSet.stream().sorted().map(LottoNumber::toString).collect(Collectors.joining(", ")).strip();
    }
}
