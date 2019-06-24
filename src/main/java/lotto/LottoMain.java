package lotto;

public class LottoMain {
    public static void main(String[] args) {
        int inputAmount = InputView.inputAmount();
        LottoVendingMachine lottoVendingMachine = new LottoVendingMachine();
        lottoVendingMachine.buyLottos(inputAmount, new LottoGeneratorRandom());

        OutputView.outputCnt(lottoVendingMachine.size());
        OutputView.outputLottos(lottoVendingMachine.getLottos());

        String winningNumber = InputView.inputWinningNumber();

        LottoResult lottoResult = new LottoResult(lottoVendingMachine.resultLottoGames(winningNumber));
        OutputView.winningNumberPrint(lottoResult, inputAmount);

    }
}
