package lottogame.console.purchase;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import lottogame.controller.spi.PurchaseViewer;
import lottogame.domain.LottoTicket;

public class ConsolePurchaseViewer implements PurchaseViewer {

    @Override
    public void draw(List<LottoTicket> lottoTickets) {
        System.out.printf("%d개를 구매했습니다.%n", lottoTickets.size());
        System.out.println(parsePrintString(lottoTickets));
    }

    private String parsePrintString(List<LottoTicket> lottoTickets) {
        StringBuilder stringBuilder = new StringBuilder();

        lottoTickets.forEach(lottoTicket -> parseLottoTicket(lottoTicket.getValues(), stringBuilder));

        return stringBuilder.toString();
    }

    private void parseLottoTicket(Set<Integer> lottoTicket, StringBuilder stringBuilder) {
        stringBuilder.append("[");
        stringBuilder.append(new TreeSet<>(lottoTicket).stream()
            .map(lottoNumber -> Integer.toString(lottoNumber))
            .collect(Collectors.joining(", ")));
        stringBuilder.append("]\n");
    }
}
