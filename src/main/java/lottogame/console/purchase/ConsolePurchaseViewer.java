package lottogame.console.purchase;

import java.util.List;
import lottogame.controller.purchase.spi.PurchaseViewer;
import lottogame.domain.LottoTicket;

public class ConsolePurchaseViewer implements PurchaseViewer {

    @Override
    public void draw(List<LottoTicket> lottoTickets) {
    }
}
