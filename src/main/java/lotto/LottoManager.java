package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoGames;
import lotto.domain.LottoMachine;
import lotto.domain.LottoStatics;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoManager {
    private LottoMachine machine;
    private InputView inputView;
    private ResultView resultView;

    public LottoManager(LottoMachine machine, InputView inputView, ResultView resultView) {
        this.machine = machine;
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public static void main(String[] args) {
        LottoMachine machine = new LottoMachine();
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoManager manager = new LottoManager(machine,inputView,resultView);

        manager.playLotto();
    }

    private void playLotto() {
        int money = inputView.takeMoney();

        LottoGames lottoGames = machine.createLottoGames(money);

        resultView.showLottoGames(lottoGames);

        int[] lottoNumbers = inputView.takeLottoNumbers();

        resultView.showLottoStatics(machine.calculateStatics(new LottoGame(lottoNumbers)));
    }
}
