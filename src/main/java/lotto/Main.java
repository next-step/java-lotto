package lotto;

public class Main {

    public static void main(String[] args) {
        Output.showBuyLotto();
        int purchase = Input.insertPurchase();
        Buyer buyer = new Buyer(purchase);
        int lottoCount = buyer.buyLotto();
        Output.showLottoCount(lottoCount);

        LottoCreator lottoCreator = new LottoCreator();
        lottoCreator.makeLottoTicket();
        LottoTickets lottoTickets = lottoCreator.makeLottoTickets(lottoCount);
        Output.showLottoTickets(lottoTickets);

        Output.showWinningNumber();
        String winningNumberInput = Input.insertWinningNumber();
        Output.showBonusNumber();
        int bonusNumber = Input.insertBonusNumber();
        WinningNumber winningNumber = lottoCreator.
                makeWinningNumber(winningNumberInput, bonusNumber);

        WinningResult winningResult = new WinningResult(lottoTickets, winningNumber);
        Output.showWinningStatus(winningResult, winningResult.calculateYield(purchase));
    }
}
