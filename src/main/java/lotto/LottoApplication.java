package lotto;

public class LottoApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        Lottos lottos = new Lottos(inputView.readPurchaseAmount());
        ResultView.viewLottos(lottos);

        Lotto winningLotto = new Lotto(inputView.readWinningNumbers());
        ResultView.viewResult(new LottoResult(lottos, winningLotto));
    }
}
