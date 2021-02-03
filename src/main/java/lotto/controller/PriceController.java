package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Price;
import lotto.domain.RevenueCluster;
import lotto.domain.TicketCount;
import lotto.domain.Tickets;
import lotto.view.DataView;
import lotto.view.ErrorView;
import lotto.view.RequestView;
import lotto.view.ResultOutputView;

public class PriceController {

    private static TicketCount totalTicketCount, manualTicketCount;
    private static Tickets manualTickets;
    private final DataView dataView = new DataView();
    private final ErrorView errorView;
    private final RequestView requestView;
    private final ResultOutputView resultOutputView = new ResultOutputView();
    private RevenueCluster revenueCluster;
    private Price price;

    public PriceController(ErrorView errorView, RequestView requestView) {
        this.errorView = errorView;
        this.requestView = requestView;
    }

    public Tickets getPriceAndGenerateTickets() {
        requestPriceOfTicketToBuy();
        requestPriceOfManualTicketToBuy();
        requestManualTicketNumber();
        dataView.printLottoPurchaseCount(
            manualTicketCount.getTicketCount(),
            totalTicketCount.minus(manualTicketCount).getTicketCount()
        );
        return generateTickets();
    }

    private void requestPriceOfTicketToBuy() {
        try {
            String money = requestView.requestPriceFromUser();
            price = new Price(money);
            totalTicketCount = new TicketCount(price.calculateTicketCount());
        } catch (IllegalArgumentException e) {
            errorView.printErrorPurchasePrice();
            requestPriceOfTicketToBuy();
        }
    }

    private void requestPriceOfManualTicketToBuy() {
        try {
            String ticketCount = requestView.requestManualLottoCount();
            manualTicketCount = new TicketCount(ticketCount, totalTicketCount);
        } catch (IllegalArgumentException e) {
            errorView.printErrorManualTicketCount();
            requestPriceOfManualTicketToBuy();
        }
    }

    private void requestManualTicketNumber() {
        try {
            List<String> ticketBundle = requestView.requestManualLottoNumber(
                manualTicketCount.getTicketCount()
            );
            manualTickets = new Tickets(ticketBundle, manualTicketCount);
        } catch (IllegalArgumentException e) {
            errorView.printErrorManualLottoNumber(manualTicketCount.getTicketCount());
            requestManualTicketNumber();
        }
    }

    private Tickets generateTickets() {
        Tickets tickets = new Tickets(
            new TicketCount(
                price.calculateTicketCount()
            ).minus(manualTicketCount));
        tickets.buyTickets();
        tickets.merge(manualTickets);
        dataView.printGeneratedTickets(tickets.getTickets());
        return tickets;
    }

    public void statisticsTotal(Lotto lotto) {
        statisticsTicketsAndPrint(lotto);
        calculateTotalPrizeAndPrint();
    }

    private void statisticsTicketsAndPrint(Lotto lotto) {
        revenueCluster = lotto.statisticsTicket();
        resultOutputView.printLottoStatics(
            revenueCluster.getRevenueCluster()
        );
    }

    private void calculateTotalPrizeAndPrint() {
        int total = revenueCluster.calculateTotalPrize();
        resultOutputView
            .printTotalRevenue(
                price
                    .calculateYield(total)
            );
    }
}
