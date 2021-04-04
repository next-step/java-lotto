package step3.service;

import step3.domain.lotto.Lotto;
import step3.domain.money.Money;
import step3.domain.shop.LottoShop;
import step3.domain.winning.WinningCheckMachine;
import step3.domain.winning.WinningLotto;
import step3.domain.winning.WinningResult;
import step3.strategy.LottoShuffleStrategy;

import java.util.List;
import java.util.Objects;


// holder 방법으로 싱글턴 구현하자니, 생성자 매개변수를 설정할 수 없네요
// 그래서 일반적인 싱글턴으로 했습니다.
public final class LottoService {

    private static LottoService instance;

    private final LottoShop lottoShop;
    private final WinningCheckMachine winningCheckMachine;
    private final LottoShuffleStrategy lottoShuffleStrategy;

    private LottoService(LottoShuffleStrategy lottoShuffleStrategy) {
        this.lottoShop = LottoShop.getInstance();
        this.winningCheckMachine = WinningCheckMachine.getInstance();
        this.lottoShuffleStrategy = lottoShuffleStrategy;
    }

    public static final LottoService getInstance(LottoShuffleStrategy lottoShuffleStrategy) {
        if (Objects.isNull(instance) || instance.lottoShuffleStrategy != lottoShuffleStrategy) {
            instance = new LottoService(lottoShuffleStrategy);
        }
        return instance;
    }

    public final List<Lotto> getLottos(Money money) {
        return lottoShop.buyLottos(money.getMoney(), lottoShuffleStrategy);
    }

    public final WinningResult getWinningResult(List<Lotto> userLottos, WinningLotto winningLotto) {
        return winningCheckMachine.getWinningResult(userLottos, winningLotto);
    }

}
