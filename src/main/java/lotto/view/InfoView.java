package lotto.view;

import lotto.domain.Game;
import lotto.domain.LottoNumber;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTickets;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class InfoView {
    private static final String NUMBER_JOIN_DELIMITER_STRING = ",";

    private final Game game;

    public InfoView(Game game) {
        this.game = game;
    }

    public void countOfTicket() {
        System.out.println(format("수동으로 %d장, 자동으로 %d개를 구매했습니다.",
                game.sizeOfManualLottoTickets(),
                game.sizeOfAutoLottoTickets()));
    }

    public void ticketNumbers() {
        LottoTickets lottoTickets = game.getAllLottoTickets();

        for (LottoTicket ticket : lottoTickets.getTickets()) {
            printNumbers(ticket.getLottoNumbers());
        }
    }

    private void printNumbers(Set<LottoNumber> lottoNumbers) {
        List<String> numbers = lottoNumbers.stream()
                .map(item -> item.getNumber())
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.toList());

        System.out.println(format("[%s]", String.join(NUMBER_JOIN_DELIMITER_STRING, numbers)));
    }
}
