package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoGenerator implements LottoGenerator {

    private List<String> manualTickets;

    public ManualLottoGenerator(List<String> manualTickets) {
        this.manualTickets = manualTickets;
    }

    @Override
    public List<Ticket> generate() {
        List<Ticket> tickets = new ArrayList<>();

        for (String s : manualTickets) {
            tickets.add(convertToTicket(s.split(", ")));
        }

        return tickets;
    }

    private Ticket convertToTicket(String[] str) {
        List<LottoNo> list = Arrays
                .stream(str)
                .map(s -> new LottoNo(Integer.parseInt(s)))
                .collect(Collectors.toList());

        LottoValidator.validate(list);
        return new Ticket(list);
    }
}
