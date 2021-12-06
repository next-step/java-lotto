package step4;

import step4.domain.*;
import step4.domain.generator.RandomLottoGenerator;
import step4.dto.LottoInformation;
import step4.dto.LottoResult;
import step4.view.InputView;
import step4.view.OutputView;

public class main {

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(new AutoLottoSeller(new RandomLottoGenerator()), new ManualLottoSeller());
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Lottos lottos = buy(lottoGame, inputView, outputView);

        result(lottoGame, inputView, outputView, lottos);
    }

    private static void result(LottoGame lottoGame, InputView inputView, OutputView outputView, Lottos lottos) {
        WinningLotto winningLotto = inputView.inputWinningLotto();
        LottoResult result = lottoGame.result(lottos, winningLotto);
        outputView.renderWithWinningHistory(result);
    }

    private static Lottos buy(LottoGame lottoGame, InputView inputView, OutputView outputView) {
        LottoInformation lottoInformation = inputView.inputLottoInfo();
        Lottos lottos = lottoGame.buy(lottoInformation);
        outputView.renderWithLottos(lottos);
        return lottos;
    }
}
