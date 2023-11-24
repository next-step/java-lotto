package com.fineroot.lotto.domain;

import com.fineroot.lotto.dto.WinningNumberSet;
import com.fineroot.lotto.util.LottoNumberCache;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto{
    private final Set<LottoNumber> lottoNumberSet;


    private Lotto(Set<LottoNumber> lottoNumberSet) {
        this.lottoNumberSet = lottoNumberSet;
    }

    public static Lotto from(Integer... numbers) {
        return new Lotto(Arrays.stream(numbers).map(LottoNumberCache::fromLottoNumber).collect(Collectors.toSet()));
    }

    public Lotto copy() {
        return new Lotto(new HashSet<>(lottoNumberSet));
    }

    public static Lotto create() {
        return new Lotto(LottoNumberCache.createLottoNumberSet());
    }


    public WinningRank matchWithWinningNumber(WinningNumberSet winningNumberSet) {
        return WinningRank.valueOf(
                (int) lottoNumberSet.stream().filter(winningNumberSet::contains)
                        .count(), winningNumberSet.hasBonus(lottoNumberSet));
    }

    @Override
    public String toString() {
        return lottoNumberSet.stream().sorted().map(LottoNumber::toString).collect(Collectors.joining(", ")).strip();
    }
}
