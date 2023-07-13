package lottogame.console.purchase;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import lottogame.controller.purchase.spi.PurchaseViewer;
import lottogame.domain.response.LottoTicketResponse;

public class ConsolePurchaseViewer implements PurchaseViewer {

    @Override
    public void draw(List<LottoTicketResponse> lottoTicketResponses) {
        System.out.printf("%d개를 구매했습니다.%n", lottoTicketResponses.size());
        System.out.println(parsePrintString(lottoTicketResponses));
    }

    private String parsePrintString(List<LottoTicketResponse> lottoTicketResponses) {
        StringBuilder stringBuilder = new StringBuilder();

        lottoTicketResponses.forEach(
            lottoTicketResponse -> parseLottoTicket(lottoTicketResponse.getNumbers(), stringBuilder));

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
