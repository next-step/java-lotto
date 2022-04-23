package me.devyonghee.lotto.view;

import me.devyonghee.lotto.view.dto.LottoTicketsResponse;

import java.io.PrintStream;
import java.util.List;
import java.util.Objects;

public final class ResultView {

    private static final String NULL_OUTPUT_ERROR_MESSAGE = "output must not be null";
    private static final String PURCHASE_TICKETS_NUMBER_MESSAGE_FORMAT = "%d개를 구매했습니다.\n";

    private final PrintStream output;

    private ResultView(PrintStream output) {
        Objects.requireNonNull(output, NULL_OUTPUT_ERROR_MESSAGE);
        this.output = output;
    }

    public static ResultView from(PrintStream output) {
        return new ResultView(output);
    }

    public void printTickets(LottoTicketsResponse response) {
        List<List<Integer>> tickets = response.getTickets();
        output.printf(PURCHASE_TICKETS_NUMBER_MESSAGE_FORMAT, tickets.size());
        for (List<Integer> ticket : tickets) {
            output.println(ticket);
        }
    }
}
