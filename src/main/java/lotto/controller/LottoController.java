package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Price;
import lotto.domain.Revenue;
import lotto.domain.Ticket;
import lotto.domain.WinningNumber;
import lotto.util.NumberUtils;
import lotto.util.ValidatorUtils;
import lotto.view.InputHandler;
import lotto.view.OutputHandler;

public class LottoController {

    private ValidatorUtils validatorUtils = new ValidatorUtils();
    private OutputHandler outputHandler = new OutputHandler();
    private InputHandler inputHandler = new InputHandler();
    private Price price;
    private String money, winningNumberInput, bonusNumber;
    private Map<Revenue, Integer> revenueCluster;
    private List<Ticket> tickets;
    private Lotto lotto;

    public void getPriceAndGenerateTickets() {
        requestPriceOfTicketToBuy();
        generateTickets();
    }

    public void getWinningAndBonusNumber() {
        requestWinningNumber();
        requestBonusNumber();
    }

    public void statisticsTicketAndTotalPrize() {
        statisticsTicket();
        calculateTotalPrize();
    }

    private void requestPriceOfTicketToBuy() {
        try {
            money = inputHandler.requestPriceFromUser();
            validatorUtils.isPriceValidate(money);
            price = new Price(Integer.parseInt(money));
            outputHandler.printLottoPurchaseCount(price.calculateTickets());
        } catch (IllegalArgumentException e) {
            outputHandler.printErrorPurchasePrice();
            requestPriceOfTicketToBuy();
        }
    }

    private void generateTickets() {
        tickets = price.buyTickets();
        outputHandler.printGeneratedTickets(tickets);
    }

    private void requestWinningNumber() {
        try {
            winningNumberInput = inputHandler.requestWinningNumber();
            validatorUtils.validateWinningNumber(winningNumberInput);
        } catch (IllegalArgumentException e) {
            outputHandler.printErrorWinningNumber();
            requestWinningNumber();
        }
    }

    private void requestBonusNumber() {
        try {
            bonusNumber = inputHandler.requestBonusNumber();
            validatorUtils.validateBonusNumber(bonusNumber);
        } catch (IllegalArgumentException e) {
            outputHandler.printErrorBonusBall();
            requestBonusNumber();
        }
    }

    private void statisticsTicket() {
        WinningNumber winningNumber = new WinningNumber(
            new Ticket(NumberUtils.convertStringToIntegerList(winningNumberInput)),
            Integer.parseInt(bonusNumber));
        lotto = new Lotto(winningNumber, tickets);
        revenueCluster = lotto.statisticsTicket();
        outputHandler.printLottoStatics(revenueCluster);
    }

    private void calculateTotalPrize() {
        int total = lotto.calculateTotalPrize(revenueCluster);
        Double yield = NumberUtils.calculateYield(Integer.parseInt(money), total);
        outputHandler.printTotalRevenue(yield);
    }
}
