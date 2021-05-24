package io.mwkwon.lotto.domain;

import io.mwkwon.lotto.constant.LottoConstants;
import io.mwkwon.lotto.enums.Rank;
import io.mwkwon.lotto.interfaces.InputView;
import io.mwkwon.lotto.interfaces.LottoGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class LottoStore {

    public BuyLottos buyAutoLottos(LottoGenerator lottoGenerator, LottoPayment lottoPayment) {
        return lottoGenerator.createAutoLottos(lottoPayment);
    }

    public Lotto createWinningLotto(InputView inputView) {
        String value = inputView.requestWinningLottoNumbers(LottoConstants.REQUEST_WINNING_LOTTO_MESSAGE);
        return new Lotto(value);
    }

    public WinningRanks calcLottosRank(BuyLottos buyLottos, Lotto winningLotto) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto buyLotto : buyLottos.lottos()) {
            Rank rank = this.calcLottoRank(buyLotto, winningLotto);
            ranks.add(rank);
        }
        List<Rank> winningRanks = ranks.stream().filter(rank -> rank != Rank.MISS).collect(Collectors.toList());
        return new WinningRanks(winningRanks);
    }

    private Rank calcLottoRank(Lotto buyLotto, Lotto winningLotto) {
        int matchCount = 0;
        for (LottoNumber lottoNumber : winningLotto.lottoNumbers()) {
            matchCount = calcMatchCount(matchCount, buyLotto, lottoNumber);
        }
        return Rank.getRankByMatchCount(matchCount);
    }

    private int calcMatchCount(int matchCount, Lotto buyLotto, LottoNumber lottoNumber) {
        if (buyLotto.lottoNumbers().contains(lottoNumber)) {
            matchCount++;
        }
        return matchCount;
    }

}
