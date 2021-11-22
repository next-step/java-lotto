package lotto.service;

import lotto.domain.*;
import lotto.vo.*;

import java.math.BigDecimal;
import java.util.List;

public class LottoService {

    private static final String BONUS_BALL_NOT_CONTAINS_LOTTO = "보너스 볼은 당첨 번호안에 포함되면 안됩니다.";

    private final LottoSeller lottoSeller;

    public LottoService(LottoSeller lottoSeller) {
        this.lottoSeller = lottoSeller;
    }


    public Lottos buyLotto(Money money) {
        return lottoSeller.sellLotto(money);
    }

    public WinningHistory getWinningHistory(Lotto winningLotto, LottoNumber bonus, Wallet wallet) {
        Lottos lottos = wallet.getLottos();
        List<WinningRank> winningRanks = findWinningRanks(lottos, winningLotto, bonus);
        Money winningMoney = getWinningMoney(winningRanks);
        Money originMoney = wallet.getMyMoney();

        return WinningHistory.create(originMoney, winningRanks, winningMoney);
    }

    private List<WinningRank> findWinningRanks(Lottos lottos, Lotto winningLotto, LottoNumber bonus) {
        return WinningRank.findWinningRanks(lottos, winningLotto, bonus);
    }

    private Money getWinningMoney(List<WinningRank> winningRanks) {
        return winningRanks.stream()
                .map(winningRank -> winningRank.getReward())
                .reduce((left, right) -> left.add(right))
                .orElseGet(() -> Money.create(BigDecimal.ZERO));
    }

    public void validBonus(Lotto winningLotto, LottoNumber bonus) {
        if (winningLotto.containLottoNumber(bonus)) {
            throw new IllegalArgumentException(BONUS_BALL_NOT_CONTAINS_LOTTO);
        }
    }
}
