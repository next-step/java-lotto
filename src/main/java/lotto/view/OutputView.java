package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;

public class OutputView {

    private static final OutputView outputView = new OutputView();

    private OutputView() {
    }


    public static OutputView getInstance() {
        return outputView;
    }


    public void showPlayerTicketNumbers(List<LottoTicket> playerTickets) {
        int playerTicketsCount = playerTickets.size();

        System.out.println(String.format("%d개를 구매 했습니다.", playerTicketsCount));

        for (LottoTicket ticket : playerTickets) {
            List<LottoNumber> value = ticket.value();
            List<Integer> collect = value.stream().map(e -> e.value()).collect(Collectors.toList());
            System.out.println(collect);
        }
    }
}
