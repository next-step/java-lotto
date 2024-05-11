public class LottoApplication {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();

        int budget = InputView.inputPrice();
        Lottos lottos = lottoGame.buy(budget);

        InputView.printBuyList(lottos);
        LottoNumbers winningNumbers = new LottoNumbers(InputView.inputWinningNumbers());

        WinningResults winningResults = lottos.draw(lottos, winningNumbers);

        WinningResultsView.printWinningResults(winningResults);
    }
}
