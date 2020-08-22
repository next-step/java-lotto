package step3;

import step3.model.LottoNumberGenerator;
import step3.model.LottoTicket;
import step3.view.InputView;
import step3.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoExtractorMain {
    public static final String DELIMITER = ",";

    public static void main(String[] args) {
        List<LottoTicket> ticketList = new ArrayList<>();
        int amount = InputView.askQuestion();
        LottoNumberGenerator generator = new LottoNumberGenerator();
        int trials = InputView.printNumberOfTickets(amount);

        for (int i = 0; i < trials; i++) {
            ticketList.add(generator.generatedLottoTicketByRandom());
            System.out.println(ticketList.get(i).printListMemberWithTemplate());
        }

        String[] answerNumber = InputView.checkWinNumber().split(DELIMITER);
        OutputView.checkStatistics(ticketList, answerNumber);
    }
}
