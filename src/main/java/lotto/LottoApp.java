package lotto;

import lotto.biz.LottoService;
import lotto.view.InputConstants;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.stream.IntStream;

public class LottoApp {

    public static void main(String[] args) {
        LottoService service = new LottoService();
        service.setPurchaseValue(InputView.question(InputConstants.PURCHASE_QUESTION));

        IntStream.range(0, Integer.parseInt(InputView.question(InputConstants.MANUAL_LOTTO_COUNT_QUESTION))).forEach(
                i -> {
                    if(i==0){
                        InputView.question(InputConstants.MANUAL_LOTTO_NUMBERS_QUESTION);
                    }
                    service.setManualLottoNumbers(InputView.inputValue());
                }
        );

        ResultView.showLottoCountInfo(service.getManualLottoCount(),service.getAutoLottoCount());

        service.setAutoLottoNumbers();

        ResultView.showAllTickets(service.getGames());

        service.setWinningNumbers(InputView.question(InputConstants.WINNING_NUMBERS_QUESTION));
        service.setBonusNumber(InputView.question(InputConstants.BONUS_NUMBER_QUESTION));
        service.aggregateWinningStatistics();

        ResultView.showWinningStatistics(service.getStatistic());
        ResultView.showProfit(service.getStatistic(),service.getPurchaseValue());

    }
}
