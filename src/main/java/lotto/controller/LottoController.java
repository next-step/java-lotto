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

    private String money;
    private List<Ticket> tickets;
    private String winningNumberInput;
    private String bonusNumber;

    public LottoController() {
        getPriceFromUser();
        purchaseTicket();
        getWinningNumberFromUser();
        getBonusNumberFromUser();
        returnFinalLottoResult();
    }

    public void getPriceFromUser() {
        money = inputHandler.requestPriceFromUser();
        if (!validator.isPriceValidate(money)) {
            outputHandler.printErrorPurchasePrice();
            System.exit(0);
        }
    }

    public void purchaseTicket() {
        Price price = new Price(Integer.parseInt(money));
        outputHandler.printLottoPurchaseCount(price.calculateTickets());
        tickets = price.buyTickets();
        outputHandler.printGeneratedTickets(tickets);
    }

    public void getWinningNumberFromUser() {
        winningNumberInput = inputHandler.requestWinningNumber();
        if (!validator.validateWinningNumber(winningNumberInput)) {
            outputHandler.printErrorWinningNumber();
            System.exit(0);
        }
    }

    public void getBonusNumberFromUser() {
        bonusNumber = inputHandler.requestBonusNumber();
        if (!validator.validateBonusNumber(bonusNumber)) {
            outputHandler.printErrorBonusBall();
            System.exit(0);
        }
    }

    public void returnFinalLottoResult() {
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
