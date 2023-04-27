package step2;

public class LottoMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoService lottoService = new LottoService();
        LottoTicketBuyRequest request = inputView.buyLotto();
        resultView.printLottoTickets(lottoService.createTickets(request.getLottoCount(), new LottoTicketAutoCreateStrategy()));


    }
}
