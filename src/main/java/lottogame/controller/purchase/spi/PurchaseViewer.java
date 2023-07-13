package lottogame.controller.purchase.spi;

import java.util.List;
import lottogame.domain.response.LottoTicketResponse;

public interface PurchaseViewer {

    void draw(List<LottoTicketResponse> lottoTickets);

}
