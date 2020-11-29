package lotto;

public class LottoGameApplication {

    public static void main(String[] args){
        int buyPrice = InputView.inputBuyLottoPrice();
        LottoTicket lottoTicket = LottoGameService.buyLotto(buyPrice);
        PrintView.printBuyLottoQty(lottoTicket.getLottoList().size());
        PrintView.printLottoNumber(lottoTicket.getLottoList());
        LottoWinner lottoWinner = InputView.inputWinnerLottoNumber();
        lottoTicket = lottoWinner.matchingWinnerNumber(lottoTicket);
        PrintView.printLottoStatistics(lottoTicket.getLottoRankList());
        PrintView.printWinnerLate(lottoTicket);

    }
}
