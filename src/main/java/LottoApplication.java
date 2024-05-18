public class LottoApplication {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();

        int budget = InputView.inputPrice();
        Lottos lottos = lottoGame.buy(budget);

        InputView.printBuyList(lottos);

        Lotto winningLotto = new Lotto(InputView.inputWinningNumbers());
        LottoNumber bonusNumber = LottoNumber.of(InputView.inputBonusNumber());

        WinningResults winningResults = lottos.draw(winningLotto, bonusNumber);

        WinningResultsView.printWinningResults(winningResults);
    }
}
