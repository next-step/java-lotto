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

  private static void initializePhase() {
    ticketPublisher = new TicketPublisher();
    dataExporter = new DataExporter();
    budget = Budget.of(InputView.askBudget());

    // 수동 희망 갯수 입력 받기
    int numManual = InputView.askNumManualLotto();
    budget.validateRequestByNumTicket(numManual);

    // 수동 번호 입력 받기
    List<String> rawNumbers = InputView.askManualLottoNumbers(numManual);
    List<LottoNumberBundle> convertedInputs = DataImporter
        .convertStringToBundle(rawNumbers);
    tickets = ticketPublisher.publishManualTickets(convertedInputs, budget);

    //자동 번호 발급
    tickets.addAll(ticketPublisher.publishAutoTickets(budget));
  }

  private static void currentStatusControlPhase() {
    // 발급 번호 출력
    dataExporter.setLottoTicketsDTO(tickets.exportData());
    dataExporter.setTicketPublisherDTO(ticketPublisher.exportData());
    ResultView.printLottoInfo(dataExporter);

    // 당첨 번호 입력 받기
    winningNumber = WinningNumber.of(LottoNumberBundle.of(InputView.askWinningNumber()));
    winningNumber.addBonusNumber(LottoNumber.of(InputView.askBonusNumber()));

    lottoResult = tickets.settle(winningNumber);
  }

  private static void statisticsPhase() {
    ResultView.printStatisticsOpening();
    dataExporter.setLottoResultDTO(lottoResult.exportData());
    ResultView.printRewards(dataExporter);

    ResultView.printIncome(budget.calculateRatio(lottoResult.calculateIncome()));
    ResultView.printDescription(budget.getDescriptiveStatus(lottoResult.calculateIncome()));
  }

  public static void main(String[] args) {
    initializePhase();
    currentStatusControlPhase();
    statisticsPhase();
  }
}
