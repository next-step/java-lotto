package lotto;

import lotto.biz.LottoService;
import lotto.util.ParseUtil;
import lotto.view.InputConstants;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.stream.IntStream;

import static lotto.biz.LottoService.COMMA;

public class LottoApp {

    public static void main(String[] args) {
        LottoService service = new LottoService();
        service.setPurchaseValue(Integer.parseInt(InputView.question(InputConstants.PURCHASE_QUESTION)));

        service.setManualLottoCount(Integer.parseInt(InputView.question(InputConstants.MANUAL_LOTTO_COUNT_QUESTION)));
        for (int i = 0; i < service.getManualLottoCount(); i++) {
            if (i == 0) {
                System.out.println(InputConstants.MANUAL_LOTTO_NUMBERS_QUESTION);
            }
            service.addManualLottoNumbers(ParseUtil.convertStringToIntegerList(InputView.inputValue(), COMMA));
        }

        ResultView.showLottoCountInfo(service.getManualLottoCount(), service.getAutoLottoCount());

        service.addAutoLottoNumbers();

        ResultView.showAllTickets(service.getGames());

        service.setWinningNumbers(InputView.question(InputConstants.WINNING_NUMBERS_QUESTION));
        service.setBonusNumber(InputView.question(InputConstants.BONUS_NUMBER_QUESTION));
        service.aggregateWinningStatistics();

        ResultView.showWinningStatistics(service.getStatistic());
        ResultView.showProfit(service.getStatistic(), service.getPurchaseValue());

    }
}
