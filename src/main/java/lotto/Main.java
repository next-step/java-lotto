package lotto;

public class Main {

    public static void main(String[] args) {
        Buyer buyer = new Buyer();
        LottoCreator lottoCreator = new LottoCreator();

        Output.showBuyLotto();
        int lottoCount = buyer.buyLotto(Input.insertPurchase());
        Output.showLottoCount(lottoCount);
        lottoCreator.makeLottoTicket();
        Output.showLottoTickets(lottoCreator.makeLottoTickets(lottoCount));

        Output.showWinningNumber();
        String winningNumber = Input.insertWinningNumber();
        Output.showBonusNumber();
        int bonusNumber = Input.insertBonusNumber();
//        lottoCreator.makeWinningNumber(winningNumber, bonusNumber);
        System.out.println(lottoCreator.makeWinningNumber(winningNumber, bonusNumber));
    }
}
