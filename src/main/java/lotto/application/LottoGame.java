package lotto.application;

import lotto.domain.WinningLotto;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumberFactory;
import lotto.domain.LottoPrice;
import lotto.domain.Lottos;
import lotto.domain.policy.AutoLottoGenerator;
import lotto.domain.policy.LottoPolicy;
import lotto.domain.policy.ManualLottoGenerator;

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
        int manualLottoQuantity = inputView.manualLottoQuantity();

        LottoPolicy manualLottoGenerator = new ManualLottoGenerator(inputView.manualLottos(manualLottoQuantity));
        LottoPolicy autoLottoGenerator = new AutoLottoGenerator();

        Lottos manualLottos = new LottoMachine(manualLottoGenerator).buyLotto(manualLottoQuantity);
        Lottos manualAndAutoLottos = manualLottos.compositeLotto(new LottoMachine(autoLottoGenerator).buyLotto(lottoPrice.lottoCount(purchase) - manualLottos.count()));

        outputView.lottos(manualAndAutoLottos, manualLottoQuantity, lottoPrice.lottoCount(purchase) - manualLottoQuantity);

        WinningLotto winningLotto = manualAndAutoLottos.checkWinningNumber(new Lotto(inputView.winningNumbers()), LottoNumberFactory.getLottoNumber(inputView.inputBonusBall()));

        outputView.winningStatistics(winningLotto);
        outputView.winningStatistics(winningLotto, purchase);
    }
}
