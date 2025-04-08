import domain.*;
import domain.LottoGame;
import domain.Lottos;
import domain.PrizeEnum;
import views.InputView;
import views.ResultView;

import java.math.BigDecimal;
import java.util.Map;

public class LottoMain {

    public static void main(String[] args) {

        int ticketCount = InputView.inputBuyAmountGetTicketCount();

        if(ticketCount == 0) return;

        int manualTicketCount = InputView.inputBuyManualTicketCount();

        String[] manualTicketNumbers = InputView.inputManualTicketNumbers(manualTicketCount);

        LottoGame lottoGame = new LottoGame().buy(ticketCount, manualTicketNumbers);

        ResultView.printLottoNumber(lottoGame);

        LottoNumbers winNumbers = InputView.inputWinNumbers();

        int bonus = InputView.inputBonusNumbers();

        Map<PrizeEnum, Integer> summaryMap = lottoGame.calculateWinResult(winNumbers, bonus);

        ResultView.printSummary(summaryMap, BigDecimal.valueOf(ticketCount * LottoGame.TICKET_PRICE));
    }
}