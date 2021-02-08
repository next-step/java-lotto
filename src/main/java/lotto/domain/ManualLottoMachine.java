package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoMachine implements LottoMachine {

    private final String manualTickets;

    private final static String SPLIT_REGEX = "\r?\n";

    public ManualLottoMachine(String manualTickets) {
        this.manualTickets = manualTickets;
    }

    private static List<Ticket> generateLottos(String tickets) {
        if (!tickets.equals("")) {
            return Arrays.stream(tickets.split(SPLIT_REGEX))
                    .map(Ticket::new)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    @Override
    public List<Ticket> buyTicket() {
        return generateLottos(manualTickets);
    }
}
