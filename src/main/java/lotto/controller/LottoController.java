package lotto.controller;

import lotto.domain.*;
import lotto.util.NumberUtils;
import lotto.view.InputHandler;
import lotto.view.OutputHandler;

import java.util.List;
import java.util.Map;

public class LottoController {

    private final Validator validator = new Validator();
    private final OutputHandler outputHandler = new OutputHandler();
    private final InputHandler inputHandler = new InputHandler();

    public String getPriceFromUser() {
        String money = inputHandler.requestPriceFromUser();
        if (!validator.isPriceValidate(money)) {
            outputHandler.printErrorPurchasePrice();
            System.exit(0);
        }
        return money;
    }

    public List<Ticket> purchaseTicket(String money) {
        Price price = new Price(Integer.parseInt(money));
        outputHandler.printLottoPurchaseCount(price.calculateTickets());
        List<Ticket> tickets = price.buyTickets();
        outputHandler.printGeneratedTickets(tickets);
        return tickets;
    }

    public String getWinningNumberFromUser() {
        String winningNumberInput = inputHandler.requestWinningNumber();
        if (!validator.validateWinningNumber(winningNumberInput)) {
            outputHandler.printErrorWinningNumber();
            System.exit(0);
        }
        return winningNumberInput;
    }

    public String getBonusNumberFromUser() {
        String bonusNumber = inputHandler.requestBonusNumber();
        if (!validator.validateBonusNumber(bonusNumber)) {
            outputHandler.printErrorBonusBall();
            System.exit(0);
        }
        return bonusNumber;
    }

    public void returnOutput(String money, String winningNumberInput, String bonusNumber, List<Ticket> tickets) {
        WinningNumber winningNumber = new WinningNumber(new Ticket(NumberUtils.convertStringToIntegerList(winningNumberInput)),
                Integer.parseInt(bonusNumber));
        Lotto lotto = new Lotto(winningNumber, tickets);

        Map<Revenue, Integer> revenueCluster = lotto.statisticsTicket();
        outputHandler.printLottoStatics(revenueCluster);
        int total = lotto.calculateTotalPrize(revenueCluster);
        Double yield = NumberUtils.calculateYield(Integer.parseInt(money), total);
        outputHandler.printTotalRevenue(yield);
    }
}
