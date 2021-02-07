package lotto.controller;

import lotto.domain.*;
import lotto.util.NumberUtils;
import lotto.view.InputHandler;
import lotto.view.OutputHandler;

import java.util.List;
import java.util.Map;

public class LottoController {

    private final OutputHandler outputHandler = new OutputHandler();
    private final InputHandler inputHandler = new InputHandler();

    private Money money;
    private Integer manualCount;
    private List<Ticket> tickets;
    private LottoCount lottoCount;

    public LottoController() {
        getPriceFromUser();
        getManualTickets();
        getWinningNumberFromUser();
    }

    public void getPriceFromUser() {
        try {
            money = new Money(inputHandler.requestPriceFromUser());
            getManualTicketCounts();
        } catch (IllegalArgumentException e) {
            outputHandler.printErrorPurchasePrice();
            getPriceFromUser();
        }
    }

    public void getManualTicketCounts() {
        try {
            manualCount = inputHandler.requestNumberOfManualTicket();
            lottoCount = new LottoCount(money, manualCount);
        } catch (IllegalArgumentException e) {
            outputHandler.printErrorManualTicketCount();
            getManualTicketCounts();
        }
    }

    public void getManualTickets() {
        try {
            outputHandler.askLottoTicket();
            ManualLottoMachine manualLottoMachine = new ManualLottoMachine(inputHandler.requestManualTicketNumber(manualCount));
            purchaseTicket(manualLottoMachine);
        } catch (IllegalArgumentException e) {
            outputHandler.printErrorTicketNumber();
            getManualTickets();
        }
    }

    public void purchaseTicket(ManualLottoMachine manualLottoMachine) {
        tickets = manualLottoMachine.buyTicket(lottoCount.calculateAutoCount());
        outputHandler.printLottoPurchaseCount(manualCount, lottoCount.calculateAutoCount());
        outputHandler.printGeneratedTickets(tickets);
    }

    public void getWinningNumberFromUser() {
        try {
            Ticket winningTicket = new Ticket(inputHandler.requestWinningNumber());
            getBonusNumberFromUser(winningTicket);
        } catch (IllegalArgumentException e) {
            outputHandler.printErrorTicketNumber();
            getWinningNumberFromUser();
        }
    }

    public void getBonusNumberFromUser(Ticket winningTicket) {
        String bonusNumber = inputHandler.requestBonusNumber();
        if (!Validator.validateBonusNumber(bonusNumber)) {
            outputHandler.printErrorBonusBall();
            getBonusNumberFromUser(winningTicket);
        }
        returnFinalLottoResult(winningTicket, bonusNumber);
    }

    public void returnFinalLottoResult(Ticket winningTicket, String bonusNumber) {
        WinningNumber winningNumber = new WinningNumber(winningTicket,
                Integer.parseInt(bonusNumber));
        Lotto lotto = new Lotto(winningNumber, tickets);
        Map<Revenue, Integer> revenueCluster = lotto.statisticsTicket();

        outputHandler.printLottoStatics(revenueCluster);
        returnYield(lotto, revenueCluster);
    }

    public void returnYield(Lotto lotto, Map<Revenue, Integer> revenueCluster) {
        int total = lotto.calculateTotalPrize(revenueCluster);
        Double yield = NumberUtils.calculateYield(Integer.parseInt(money.toString()), total);
        outputHandler.printTotalRevenue(yield);
    }
}
