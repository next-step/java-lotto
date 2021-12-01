package lotto.view;

import lotto.domain.dto.LottoResult;
import lotto.domain.entity.Budget;
import lotto.domain.entity.LottoNumber;
import lotto.domain.entity.LottoTicket;
import lotto.domain.entity.LottoTickets;

public class ViewImpl implements View{

  private static final String BUY_TICKET_RESULT_MESSAGE = "수동으로 %d장, 자동으로 %d장을 구매했습니다.";

  private final InputView inputView;
  private final ResultView resultView;

  public ViewImpl(InputView inputView, ResultView resultView) {
    this.inputView = inputView;
    this.resultView = resultView;
  }

  @Override
  public Budget getBudget() {
    return inputView.inputBudget();
  }

  @Override
  public LottoTicket getWinning() {
    return inputView.inputWinning();
  }

  @Override
  public LottoNumber getBonus() {
    return inputView.inputBonus();
  }

  @Override
  public LottoTickets getManualTickets() {
    return inputView.inputManualTickets();
  }

  @Override
  public void printBuyResult(LottoTickets manualTickets, LottoTickets lottoTickets) {
    resultView.printResult(String.format(BUY_TICKET_RESULT_MESSAGE, manualTickets.size(), lottoTickets.size() - manualTickets.size()));
    resultView.printResult(lottoTickets.toString());
  }

  @Override
  public void printLottoResult(LottoResult result) {
    resultView.printResult(result.toString());
  }

}
