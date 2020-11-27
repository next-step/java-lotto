package lotto;

public class LottoGameApplication {

    public static void main(String[] args){
        int buyPrice = InputView.inputBuyLottoPrice();
        LottoGameService.buyLotto(buyPrice);
        InputView.inputWinnerLottoNumber();
        LottoWinner.matchingWinnerNumber();
        PrintView.printLottoStatistics();
        PrintView.printWinnerLate();

    }
}
