import domain.Lotto;
import domain.LottoGame;
import domain.Lottos;
import domain.PrizeEnum;
import views.InputView;
import views.ResultView;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class LottoMain {

    public static void main(String[] args) {

        int ticketCount = InputView.inputBuyAmountGetTicketCount();

        LottoGame lottoGame = new LottoGame();
        lottoGame.buy(ticketCount);

        Lottos lottos = lottoGame.getLottos();

        ResultView.printLottoNumber(lottos);

        List<Integer> winNumbers = InputView.inputWinNumbers();

        int bonus = InputView.inputBonusNumbers();

        Map<PrizeEnum, Integer> summaryMap = lottos.getSummary(winNumbers, bonus);

        ResultView.printSummary(summaryMap, BigDecimal.valueOf(ticketCount * LottoGame.TICKET_PRICE));
    }
}
