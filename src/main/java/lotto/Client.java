package lotto;

import java.util.List;
import lotto.views.DataExporter;
import lotto.views.DataImporter;
import lotto.views.InputView;
import lotto.views.ResultView;

public class Client {

  public static void main(String[] args) {
    TicketPublisher ticketPublisher = new TicketPublisher();
    DataExporter dataExporter = new DataExporter();
    Budget budget = Budget.of(InputView.askBudget());

    // 수동 희망 갯수 입력 받기
    int numManual = InputView.askNumManualLotto();
    budget.validateRequestByNumTicket(numManual);

    // 수동 번호 입력 받기
    List<String> rawNumbers = InputView.askManualLottoNumbers(numManual);
    List<LottoNumberBundle> convertedInputs = DataImporter
        .convertStringToBundle(rawNumbers);
    LottoTickets tickets = ticketPublisher.publishManualTickets(convertedInputs, budget);

    //자동 번호 발급
    tickets.addAll(ticketPublisher.publishAutoTickets(budget));
    dataExporter.setLottoTicketsDTO(tickets.exportData());

    // 발급된 번호 출력
    // TODO 몇 개 발급되었는지 확인
    ResultView.printLottoInfo(dataExporter);

    // 당첨 번호 입력 받기
    WinningNumber winningNumber =
        WinningNumber.of(LottoNumberBundle.of(InputView.askWinningNumber()));

    // 보너스 볼을 입력 받기
    LottoNumber bonusNumber = LottoNumber.of(InputView.askBonusNumber());
    winningNumber.validateBonusNumberDuplication(bonusNumber);

    LottoResult lottoResult = tickets.settle(winningNumber, bonusNumber);

    //당첨 통계
    ResultView.printStatisticsOpening();
    dataExporter.setLottoResultDTO(lottoResult.exportData());
    ResultView.printRewards(dataExporter);

    ResultView.printIncome(budget.calculateRatio(lottoResult.calculateIncome()));
    ResultView.printDescription(budget.getDescriptiveStatus(lottoResult.calculateIncome()));
  }
}
