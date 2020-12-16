package lotto;

import java.util.List;

public class LottoGameApplication {

    public static void main(String[] args){
        int buyPrice = InputView.inputBuyLottoPrice();
        int manualBuyQty = InputView.inputBuyManualLottoQty();
        LottoTicket manualBuyLottoTicket = InputView.inputBuyManualLottoNumber(manualBuyQty);
        LottoTicket autoBuyLottoTicket = LottoGameService.autoBuyLotto(buyPrice, manualBuyLottoTicket);
        PrintView.printBuyLottoQty(manualBuyLottoTicket, autoBuyLottoTicket);
        LottoTicket lottoTicket = LottoTicket.of(manualBuyLottoTicket, autoBuyLottoTicket);
        PrintView.printLottoNumber(lottoTicket.getLottoList());
        LottoWinner lottoWinner = InputView.inputWinnerLottoNumber();
        List<Rank> lottoRank = lottoWinner.matchingWinnerNumber(lottoTicket);
        PrintView.printLottoStatistics(lottoRank);
        PrintView.printWinnerLate(lottoRank);

    }
}
