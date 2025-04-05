import domain.*;
import domain.Lotto;
import domain.LottoGame;
import domain.Lottos;
import domain.PrizeEnum;
import domain.*;
import views.InputView;
import views.ResultView;

import java.math.BigDecimal;
import java.util.Map;
import java.math.BigDecimal;
import java.util.Map;

public class LottoMain {

    public static void main(String[] args) {

        int ticketCount = InputView.inputBuyAmountGetTicketCount();

        int manualTicketCount = InputView.inputBuyManualTicketCount();

        String[] manualTicketNumbers = InputView.inputManualTicketNumbers(manualTicketCount);

        LottoGame lottoGame = new LottoGame().buy(ticketCount, manualTicketNumbers);

        Lottos lottos = lottoGame.getLottos();

        ResultView.printLottoNumber(lottos);

        LottoNumbers winNumbers = InputView.inputWinNumbers();

        int bonus = InputView.inputBonusNumbers();

        Map<PrizeEnum, Integer> summaryMap = lottos.calculateWinResult(winNumbers, bonus);

        ResultView.printSummary(summaryMap, BigDecimal.valueOf(ticketCount * LottoGame.TICKET_PRICE));
    }
}