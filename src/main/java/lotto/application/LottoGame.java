package lotto.application;

import lotto.domain.Bank;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.LottoPrice;
import lotto.domain.Lottos;
import lotto.domain.policy.AutoLotto;

public class LottoGame {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        LottoPrice lottoPrice = new LottoPrice();

        int purchase = inputView.purchase();
        int quantity = inputView.manualLottoQuantity();
        Lottos manualLottos = inputView.manualLottos(quantity);

        LottoMachine lottoMachine = new LottoMachine(new AutoLotto(), lottoPrice);
        int autoLottoCost = purchase - lottoPrice.manualLottoCost(quantity);

        Lottos manualAndAutoLotto = manualLottos.compositeLotto(lottoMachine.buyLotto(autoLottoCost));

        outputView.lottos(manualAndAutoLotto, quantity, lottoPrice.lottoCount(purchase) - quantity);

        Bank bank = manualAndAutoLotto.checkWinningNumber(new Lotto(inputView.winningNumbers()), new LottoNumber(inputView.inputBonusBall()));

        outputView.winningStatistics(bank);
        outputView.winningStatistics(bank, purchase);
    }
}
