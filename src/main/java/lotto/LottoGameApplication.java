package lotto;

import java.util.List;

public class LottoGameApplication {

    public static void main(String[] args){
        int buyPrice = InputView.inputBuyLottoPrice();
        LottoTicket lottoTicket = LottoGameService.buyLotto(buyPrice);
        PrintView.printBuyLottoQty(lottoTicket.getLottoList().size());
        PrintView.printLottoNumber(lottoTicket.getLottoList());
        LottoWinner lottoWinner = InputView.inputWinnerLottoNumber();
        List<Rank> lottoRank = lottoWinner.matchingWinnerNumber(lottoTicket);
        PrintView.printLottoStatistics(lottoRank);
        PrintView.printWinnerLate(lottoRank);

    }
}
