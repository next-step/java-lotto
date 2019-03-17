package domain;

import view.InputView;
import view.ResultView;

public class LottoGame {
    private Lottos lottos;

    public LottoGame(int numberOfLotto) {
        this.lottos = new Lottos(numberOfLotto);
    }

    public Lottos getLottos() {
        return this.lottos;
    }

    public static void main(String[] args) {
        int numberOfLottos = InputView.getNumberOfLottos();

        LottoGame lottoGame = new LottoGame(numberOfLottos);
        ResultView.printLottos(lottoGame.getLottos());

        Lotto winLotto = InputView.getWinLotto();
    }
}
