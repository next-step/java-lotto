package step3.service;


import step3.config.AppConfig;
import step3.domain.lotto.Lotto;
import step3.domain.money.Money;
import step3.domain.shop.LottoShop;
import step3.domain.winning.WinningCheckMachine;
import step3.domain.winning.WinningLotto;
import step3.domain.winning.WinningResult;
import step3.strategy.LottoShuffleStrategy;

import java.util.List;

public final class LottoService {

    private final LottoShop lottoShop;
    private final WinningCheckMachine winningCheckMachine;
    private final LottoShuffleStrategy lottoShuffleStrategy;

    private static class LottoServiceHolder {
        public static final LottoService instance = new LottoService();
    }

    private LottoService() {
        this.lottoShop = LottoShop.getInstance();
        this.winningCheckMachine = WinningCheckMachine.getInstance();
        this.lottoShuffleStrategy = AppConfig.lottoShuffleStrategy();
    }

    public static final LottoService getInstance() {
        return LottoServiceHolder.instance;
    }

    public final List<Lotto> getLottos(Money money) {
        return lottoShop.buyLottos(money.getMoney(), lottoShuffleStrategy);
    }

    public final WinningResult getWinningResult(List<Lotto> userLottos, WinningLotto winningLotto) {
        return winningCheckMachine.getWinningResult(userLottos, winningLotto);
    }

}
