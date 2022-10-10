package lotto.application;

import lotto.domain.Bank;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoPrice;
import lotto.domain.Lottos;
import lotto.domain.random.AutoLotto;

public class LottoGame {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        int purchase = inputView.purchase();
        outputView.lottoCount(purchase);

        LottoMachine lottoMachine = new LottoMachine(new AutoLotto(), new LottoPrice());
        Lottos lottos = lottoMachine.buyLotto(purchase);

        outputView.lottos(lottos);

        Bank bank = lottos.checkWinningNumber(new Lotto(inputView.winningNumbers()));

        outputView.winningStatistics(bank);
        outputView.winningStatistics(bank, purchase);
    }
}
