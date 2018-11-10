package net.chandol.lotto.domain;

import java.util.List;

import static java.util.stream.Collectors.toList;

class LottoPrizeCalculator {
    private LottoNumber winNumber;

    public LottoPrizeCalculator(LottoNumber winNumber) {
        if (winNumber == null) {
            throw new IllegalArgumentException();
        }
        this.winNumber = winNumber;
    }

    public LottoPrize findPrize(Lotto lotto) {
        int matchCount = lotto.getMatchCount(winNumber);
        return LottoPrize.getMatchingPrize(matchCount);
    }

    public LottoGameResult lottoGameResult(List<Lotto> lottos){
        List<LottoPrize> prizes = lottos.stream()
                .map(this::findPrize)
                .collect(toList());

        int buyPrice = lottos.size() * Lotto.PRICE;

        return new LottoGameResult(prizes, buyPrice);
    }
}
