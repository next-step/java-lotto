package lotto.service;

import lotto.domain.*;
import lotto.vo.*;

import java.math.BigDecimal;
import java.util.List;

public class LottoService {

    private static final String BONUS_BALL_NOT_CONTAINS_LOTTO = "보너스 볼은 당첨 번호안에 포함되면 안됩니다.";
    private static final String WALLET_NOT_HAVE_LOTTO_MESSAGE = "보너스 볼은 당첨 번호안에 포함되면 안됩니다.";

    private final Money lottoPrice;
    private final LottoSeller lottoSeller;
    private final LottoGenerator lottoGenerator;
    private final Wallet wallet;

    public LottoService(Money money, NumberGenerateStrategy strategy) {
        int price = LottoRule.LOTTO_PRICE.getValue();
        this.lottoPrice = Money.create(BigDecimal.valueOf(price));
        this.lottoGenerator = LottoGenerator.create(strategy);
        this.lottoSeller = LottoSeller.create(lottoPrice, lottoGenerator);
        this.wallet = Wallet.create(money);
    }


    public Lottos buyLotto() {
        return wallet.buyLotto(lottoSeller);
    }

    public WinningHistory getWinningHistory(Lotto winningLotto, LottoNumber bonus) {
        Lottos lottos = wallet.getLottos();
        List<WinningRank> winningRanks = checkWinning(lottos, winningLotto, bonus);
        Money winningMoney = getWinningMoney(winningRanks);
        Money originMoney = wallet.getMoneyToBuy();

        return WinningHistory.create(originMoney, winningRanks, winningMoney);
    }

    private List<WinningRank> checkWinning(Lottos lottos, Lotto winningLotto, LottoNumber bonus) {
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
