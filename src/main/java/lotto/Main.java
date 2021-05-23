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
    }
}
