package lotto;

import java.util.List;
import lotto.views.DataExporter;
import lotto.views.DataImporter;
import lotto.views.InputView;
import lotto.views.ResultView;

public class Client {

  private static TicketPublisher ticketPublisher;
  private static DataExporter dataExporter;
  private static Budget budget;
  private static LottoTickets tickets;
  private static WinningNumber winningNumber;
  private static LottoResult lottoResult;

  public static void main(String[] args) {
    initializationPhase();
    LottoTicketSetUpPhase();
    WinningNumberSetUpPhase();
    tearDownPhase();
  }

  private static void initializationPhase() {
    ticketPublisher = new TicketPublisher();
    dataExporter = new DataExporter();
    budget = Budget.of(InputView.askBudget());
  }

  private static void LottoTicketSetUpPhase() {
    // 수동 희망 갯수 입력 받기
    int numManual = InputView.askNumManualLotto();
    budget.validateRequest(numManual);

    // 수동 번호 입력 받기
    List<String> rawNumbers = InputView.askManualLottoNumbers(numManual);
    List<LottoNumberBundle> convertedInputs = DataImporter
        .convertStringToBundle(rawNumbers);

    //수동, 자동 로또 발급
    tickets = ticketPublisher.publishTickets(convertedInputs, budget);

    ResultView.printNumPublishedManualTicket(budget.getNumManualTicket());
    ResultView.printNumPublishedAutoTicket(budget.getNumAutoTicket());

    // 발급 번호 출력
    dataExporter.setLottoTicketsDTO(tickets.exportData());
    ResultView.printLottoInfo(dataExporter);
  }

  private static void WinningNumberSetUpPhase() {
    winningNumber = WinningNumber.of(LottoNumberBundle.of(InputView.askWinningNumber()));
    winningNumber.addBonusNumber(LottoNumber.of(InputView.askBonusNumber()));

    lottoResult = tickets.settle(winningNumber);
  }

  private static void tearDownPhase() {
    dataExporter.setLottoResultDTO(lottoResult.exportData());

    ResultView.printStatisticsOpening();
    ResultView.printRewards(dataExporter);
    ResultView.printIncome(budget.calculateRatio(lottoResult.calculateIncome()));
    ResultView.printDescription(budget.getDescriptiveStatus(lottoResult.calculateIncome()));
  }
}
