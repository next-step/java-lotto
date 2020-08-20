package step2;

import step2.model.LottoNumberGenerator;
import step2.model.LottoTicket;
import step2.view.InputView;

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
            String numberList = generator.retrieveLottoNumberList();
            ticketList.add(new LottoTicket(numberList));
            System.out.println(numberList);
        }

        String[] answerNumber = InputView.checkWinNumber().split(DELIMITER);
        OutputView.checkStatistics(ticketList, answerNumber);
    }
}
