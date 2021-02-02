package lotto;

import java.util.List;
import lotto.controller.LottoController;
import lotto.domain.Ticket;
import lotto.view.OutputHandler;
import lotto.view.RequestView;

public class LottoApplication {

    private static final OutputHandler outputHandler = new OutputHandler();
    private static final RequestView requestView = new RequestView();
    private static final LottoController lottoController = new LottoController();
    private static String money = null;

    public static void main(String[] args) {
        requestPriceOfTicketToBuy();
        generateTickets();
        requestWinningNumber();
        requestBonusNumber();
        statisticsTicketsAndPrint();
        calculateTotalPrizeAndPrint();
    }

    public static void requestPriceOfTicketToBuy() {
        try {
            money = requestView.requestPriceFromUser();
            outputHandler.printLottoPurchaseCount(
                lottoController.createPriceOfTicketToBuy(money)
            );
        } catch (IllegalArgumentException e) {
            outputHandler.printErrorPurchasePrice();
            requestPriceOfTicketToBuy();
        }
    }

    public static void generateTickets() {
        List<Ticket> tickets = lottoController.generateTickets();
        outputHandler.printGeneratedTickets(tickets);
    }

    public static void requestWinningNumber() {
        try {
            String winningNumberInput = requestView.requestWinningNumber();
            lottoController.requestWinningNumber(winningNumberInput);
        } catch (IllegalArgumentException e) {
            outputHandler.printErrorWinningNumber();
            requestWinningNumber();
        }
    }

    public static void requestBonusNumber() {
        try {
            String bonusNumber = requestView.requestBonusNumber();
            lottoController.requestBonusNumber(bonusNumber);
        } catch (IllegalArgumentException e) {
            outputHandler.printErrorBonusBall();
            requestBonusNumber();
        }
    }

    public static void statisticsTicketsAndPrint() {
        outputHandler.printLottoStatics(lottoController.statisticsTicket());
    }

    public static void calculateTotalPrizeAndPrint() {
        outputHandler
            .printTotalRevenue(lottoController.calculateTotalPrize(Integer.parseInt(money)));
    }
}
