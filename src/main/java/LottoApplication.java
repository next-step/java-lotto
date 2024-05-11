public class LottoApplication {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();

        int budget = InputView.inputPrice();
        Lottos lottos = lottoGame.buy(budget);

        InputView.printBuyList(lottos);
        LottoNumbers winningNumbers = new LottoNumbers(InputView.inputWinningNumbers());
        LottoNumber bonusNumber = LottoNumber.of(InputView.inputBonusNumber());

        WinningResults winningResults = lottos.draw(lottos, winningNumbers, bonusNumber);

        WinningResultsView.printWinningResults(winningResults);
    }
}
