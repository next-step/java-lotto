public class LottoApplication {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();

        int budget = InputView.inputPrice();
        Lottos lottos = lottoGame.buy(budget);

        InputView.printBuyList(lottos);
        LottoNumbers winningNumbers = LottoNumbers.fromIntegerList(InputView.inputWinningNumbers());

        WinningResults winningResults = LottoDraw.draw(lottos, winningNumbers);

        WinningResultsView.printWinningResults(winningResults);
    }
}
