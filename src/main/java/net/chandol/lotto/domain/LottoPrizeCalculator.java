package net.chandol.lotto.domain;

import net.chandol.lotto.type.LottoPrize;
import net.chandol.lotto.value.Money;
import net.chandol.lotto.value.WinningNumber;

import java.util.List;

import static java.util.stream.Collectors.toList;

class LottoPrizeCalculator {
    private WinningNumber winningNumber;

    public LottoPrizeCalculator(WinningNumber winningNumber) {
        if (winningNumber == null) {
            throw new IllegalArgumentException("당첨번호가 입력되지 않았습니다.");
        }
        this.winningNumber = winningNumber;
    }

    public LottoPrize findPrize(Lotto lotto) {
        return lotto.getMatchingLottoPrize(winningNumber);
    }

    public LottoGameResult lottoGameResult(List<Lotto> lottos) {
        List<LottoPrize> prizes = lottos.stream()
                .map(this::findPrize)
                .collect(toList());

        Money purchasePrice = Lotto.LOTTO_PRICE.multiply(lottos.size());

        return new LottoGameResult(prizes, purchasePrice);
    }
}
