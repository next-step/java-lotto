package camp.nextstep.edu.rebellion.lotto.view;

import camp.nextstep.edu.rebellion.lotto.domain.ticket.LottoTicket;
import camp.nextstep.edu.rebellion.lotto.domain.winning.LottoWinningResult;

public class ResultView {
    private static final String ENTER = "\n";
    private static final String DEFAULT_DELIMITER = ",";

    private ResultView() {}

    public static void printLottoTicket(LottoTicket lottoTicket) {
        StringBuilder builder = new StringBuilder();
        lottoTicket.getLottoNumbers().forEach(
                lottoNumber -> System.out.println(lottoNumber.getNumbers())
        );
    }

    public static void printWinningResult(LottoWinningResult result) {
    }
}
