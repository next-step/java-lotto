package edu.nextstep.lotto.step2.domain;

import edu.nextstep.lotto.step2.vo.DefaultLottoShuffle;
import edu.nextstep.lotto.step2.vo.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static edu.nextstep.lotto.step2.domain.WinningAmount.*;

public class LottoList {

    private static final int LOTTO_PRICE = 1000;
    private final List<LottoNumber> lottoNumberList;

    public LottoList(int purchaseAmount) {
        lottoNumberList = IntStream.range(0, purchaseAmount / LOTTO_PRICE)
                .mapToObj(idx -> new LottoNumber(new DefaultLottoShuffle()))
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getLottoList() {
        return lottoNumberList;
    }

    public int getMatchResult(WinningList winningList, int numberOfWins) {
        return (int) lottoNumberList.stream()
                .filter(lottoNumber -> lottoNumber.getMatchResult(winningList) == numberOfWins)
                .count();
    }

    public float getRate(WinningList winningList, int purchaseAmount) {
        long benefit = Arrays.stream(values())
                .mapToLong(amount -> amount.getBenefit().apply(this, winningList))
                .sum();

        return benefit == 0 ? 0 : (float) benefit / purchaseAmount;
    }
}
