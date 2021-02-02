package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.Price;
import lotto.domain.Revenue;
import lotto.domain.Ticket;
import lotto.domain.Tickets;
import lotto.domain.WinningInfo;
import lotto.domain.WinningNumber;
import lotto.util.NumberUtils;

public class LottoController {

    private Price price;
    private LottoNumber bonusNumber;
    private Map<Revenue, Integer> revenueCluster;
    private Tickets tickets;
    private Lotto lotto;
    private WinningNumber winningNumber;

    public int createPriceOfTicketToBuy(String money) throws IllegalArgumentException {
        price = new Price(money);
        return price.calculateTicketCount();
    }

    public List<Ticket> generateTickets() {
        tickets = new Tickets();
        tickets.buyTickets(price.calculateTicketCount());
        return tickets.getTickets();
    }

    public void requestWinningNumber(String winningNumberInput) throws IllegalArgumentException {
        winningNumber = new LottoMachine().generateWinningTicket(winningNumberInput);
    }

    public void requestBonusNumber(String bonus) throws IllegalArgumentException {
        bonusNumber = new LottoNumber(NumberUtils.returnInteger(bonus));
    }

    public Map<Revenue, Integer> statisticsTicket() {
        WinningInfo winningInfo = new WinningInfo(winningNumber, bonusNumber);
        lotto = new Lotto(winningInfo, tickets);
        revenueCluster = lotto.statisticsTicket();
        return revenueCluster;
    }

    public Double calculateTotalPrize(Integer money) {
        int total = price.calculateTotalPrize(revenueCluster);
        return NumberUtils.calculateYield(money, total);
    }
}
