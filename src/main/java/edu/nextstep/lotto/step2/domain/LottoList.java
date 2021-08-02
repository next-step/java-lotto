package edu.nextstep.lotto.step2.domain;

import edu.nextstep.lotto.step2.vo.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoList {

    private static final int LOTTO_PRICE = 1000;
    private final List<LottoNumber> lottoNumberList;

    public LottoList(int purchaseAmount) {
        lottoNumberList = IntStream.range(0, purchaseAmount / LOTTO_PRICE)
                .mapToObj(idx -> new LottoNumber())
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getLottoList() {
        return lottoNumberList;
    }

    public int getMatchResult(WinningList winningList, int numberOfWins) {
        return (int) lottoNumberList.stream()
                .filter(lottoNumber -> lottoNumber.getResult(winningList) == numberOfWins)
                .count();
    }

    public float getRate(WinningList winningList, int purchaseAmount) {
        long benefit = 0;
        benefit += WinningAmount.FOURTH.getBenefit().apply(this, winningList);
        benefit += WinningAmount.THIRD.getBenefit().apply(this, winningList);
        benefit += WinningAmount.SECOND.getBenefit().apply(this, winningList);
        benefit += WinningAmount.FIRST.getBenefit().apply(this, winningList);

        return benefit == 0 ? 0 : (float) benefit / purchaseAmount;
    }
}
