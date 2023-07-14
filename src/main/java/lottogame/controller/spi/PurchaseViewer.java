package lottogame.controller.spi;

import java.util.List;
import lottogame.domain.LottoTicket;

public interface PurchaseViewer {

    void draw(List<LottoTicket> lottoTickets);

}
