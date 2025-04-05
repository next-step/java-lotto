import domain.*;
import views.InputView;
import views.ResultView;

import java.math.BigDecimal;
import java.util.Map;

public class LottoMain {

    public static void main(String[] args) {

        int ticketCount = InputView.inputBuyAmountGetTicketCount();

        LottoGame lottoGame = new LottoGame();
        lottoGame.buy(ticketCount);

        Lottos lottos = lottoGame.getLottos();

        ResultView.printLottoNumber(lottos);

        LottoNumbers winNumbers = InputView.inputWinNumbers();

        int bonus = InputView.inputBonusNumbers();

        Map<PrizeEnum, Integer> summaryMap = lottos.calculateWinResult(winNumbers, bonus);

        ResultView.printSummary(summaryMap, BigDecimal.valueOf(ticketCount * LottoGame.TICKET_PRICE));
    }
}
