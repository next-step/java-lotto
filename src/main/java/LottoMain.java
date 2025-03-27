import domain.Lotto;
import views.InputView;
import views.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoMain {

    public static void main(String[] args) {

        int ticketCount = InputView.inputBuyAmountGetTicketCount();

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottos.add(new Lotto());
        }

        ResultView.printLottoNumber(lottos);

        List<Integer> winNumbers = InputView.inputWinNumbers();

        ResultView.printSummary(winNumbers, lottos);
    }
}
