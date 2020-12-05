package lotto.automatic;

import lotto.automatic.domain.*;
import lotto.automatic.dto.LottoBuyingMoney;
import lotto.automatic.dto.ManualLottos;
import lotto.automatic.view.InputView;
import lotto.automatic.view.OutputView;

import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGame lottoGame;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGame = new LottoGame();
    }

    public void request(){

        LottoBuyingMoney lottoBuyingMoney = getLottoMoney();
        ManualLottos manualLottos = getManualLottos(lottoBuyingMoney.getTotalCountOfLotto());
        Lottos lottos = getLottoList(lottoBuyingMoney, manualLottos);

        outputView.printLottoList(lottos);

        WinningLotto winningLotto = getWinningLotto();
        List<LottoRank> lottoRankList = winningLotto.getRankList(lottos);
        LottoResult result = getResult(lottoBuyingMoney, lottoRankList);

        outputView.printLottoResult(result);
    }

    private ManualLottos getManualLottos(int totalCountOfLotto) {
        return inputView.getManualLottos(totalCountOfLotto);
    }

    private LottoResult getResult(LottoBuyingMoney lottoBuyingMoneyAndAmount, List<LottoRank> lottoRankList) {
        return lottoGame.getLottoResult(lottoBuyingMoneyAndAmount.getInvestMoney(), lottoRankList);
    }

    private WinningLotto getWinningLotto() {
        return inputView.getWinningLottoNums();
    }

    private Lottos getLottoList(LottoBuyingMoney lottoBuyingMoney, ManualLottos manualLottos) {
        Lottos autoLotto = lottoGame.generateAutoLotto(lottoBuyingMoney.getAutoAmount(manualLottos.getManualAmount()));
        Lottos manualLotto = lottoGame.generateManualLotto(manualLottos.getRawStrings());
        autoLotto.append(manualLotto);

        return autoLotto;
    }

    private LottoBuyingMoney getLottoMoney() {
        return inputView.getLottoMoney();
    }

}
