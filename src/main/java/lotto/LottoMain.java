package lotto;

public class LottoMain {
    public static void main(String[] args) {
        int inputAmount = InputView.inputAmount();
        Money money = new Money(inputAmount);
        LottoGame lottoGame = new LottoGame(money, new LottoGeneratorRandom());

        OutputView.outputCnt(money.countOfBuyingLotto());
        OutputView.outputLottos(lottoGame.getLottos());

        String winningNumber = InputView.inputWinningNumber();
        Lotto winnigLotto = Lotto.of(winningNumber);

        LottoResult lottoResult = lottoGame.result(winnigLotto);
        OutputView.winningNumberPrint(lottoResult);

        Money prize = lottoResult.getPrize();
        OutputView.rateOfReturn(prize, money);

    }
}
