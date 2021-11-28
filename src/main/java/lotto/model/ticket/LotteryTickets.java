package lotto.model.ticket;

import lotto.model.domain.CountInfo;
import lotto.model.ticket.generator.LotteryTicketGenerator;
import lotto.view.InputView;

import java.util.*;

public class LotteryTickets {

    private final List<LotteryTicket> tickets = new ArrayList<LotteryTicket>();

    public LotteryTickets(CountInfo countInfo) {
        if(countInfo.haveManualLottery()) {
            InputView.inputManualLottery();
        }
        tickets.addAll(LotteryTicketGenerator.generateManualLotteryTicket(countInfo.getManualCount()));
        tickets.addAll(LotteryTicketGenerator.generateAutoLotteryTicket(countInfo.getAutoCount()));
    }

    public List<LotteryTicket> getTickets(){
        return Collections.unmodifiableList(this.tickets);
    }

}