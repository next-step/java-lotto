package lottogame.console.purchase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lottogame.controller.purchase.spi.PurchaseViewer;
import lottogame.domain.LottoTicket;

public class ConsolePurchaseViewer implements PurchaseViewer {

    @Override
    public void draw(List<LottoTicket> lottoTickets) {
        System.out.printf("%d개를 구매했습니다.%n", lottoTickets.size());
        System.out.println(parsePrintString(lottoTickets));
    }

    private String parsePrintString(List<LottoTicket> lottoTickets) {
        StringBuilder stringBuilder = new StringBuilder();

        lottoTickets.forEach(lottoTicket -> parseLottoTicket(lottoTicket.getLottoNumbers(), stringBuilder));

        return stringBuilder.toString();
    }

    private void parseLottoTicket(Set<Integer> lottoTickets, StringBuilder stringBuilder) {
        stringBuilder.append("[");
        stringBuilder.append(lottoTickets.stream()
            .map(lottoTicket -> Integer.toString(lottoTicket))
            .collect(Collectors.joining(", ")));
        stringBuilder.append("]\n");
    }
}
