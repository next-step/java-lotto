package lotto.view;

import lotto.domain.dto.LottoResult;
import lotto.domain.entity.Budget;
import lotto.domain.entity.LottoTicket;
import lotto.domain.entity.LottoTickets;

public class ViewImpl implements View{

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
  public void setBuyResult(LottoTickets lottoTickets) {
    resultView.printResult(String.valueOf(lottoTickets.size()));
    resultView.printResult(lottoTickets.toString());
  }

  @Override
  public void setLottoResult(LottoResult result) {
    resultView.printResult(result.toString());
  }

}
