package io.mwkwon.lotto.domain;

import io.mwkwon.lotto.enums.Rank;
import io.mwkwon.lotto.interfaces.DataGenerator;
import io.mwkwon.lotto.interfaces.LottoGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class LottoStore {

    public BuyLottos buyAutoLottos(LottoGenerator lottoGenerator, LottoPayment lottoPayment) {
        return lottoGenerator.createAutoLottos(lottoPayment);
    }

    public Lotto createWinningLotto(DataGenerator dataGenerator) {
        return dataGenerator.requestWinningLottoNumbers();
    }

    public LottoPayment createLottoPayment(DataGenerator dataGenerator) {
        return dataGenerator.requestInputPayment();
    }

    public LottoNumber createBonusBallLottoNumber(DataGenerator dataGenerator, Lotto winningLotto) {
        return dataGenerator.requestBonusBallNumber(winningLotto);
    }

    public WinningRanks calcLottosRank(BuyLottos buyLottos, Lotto winningLotto, LottoNumber bonusBallLottoNumber) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto buyLotto : buyLottos.lottos()) {
            Rank rank = this.calcLottoRank(buyLotto, winningLotto, bonusBallLottoNumber);
            ranks.add(rank);
        }
        List<Rank> winningRanks = ranks.stream().filter(rank -> rank != Rank.MISS).collect(Collectors.toList());
        return new WinningRanks(winningRanks);
    }

    private Rank calcLottoRank(Lotto buyLotto, Lotto winningLotto, LottoNumber bonusBallLottoNumber) {
        int matchCount = 0;
        for (LottoNumber lottoNumber : winningLotto.lottoNumbers()) {
            matchCount = calcMatchCount(matchCount, buyLotto, lottoNumber);
        }
        return Rank.valueOf(matchCount, buyLotto.isContains(bonusBallLottoNumber));
    }

    private int calcMatchCount(int matchCount, Lotto buyLotto, LottoNumber lottoNumber) {
        if (buyLotto.lottoNumbers().contains(lottoNumber)) {
            matchCount++;
        }
        return matchCount;
    }
}
