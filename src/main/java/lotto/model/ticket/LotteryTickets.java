package lotto.model.ticket;

import lotto.model.domain.PurchaseInfo;
import lotto.model.ticket.generator.LotteryTicketGenerator;

import java.util.*;

public class LotteryTickets {

    private final List<LotteryTicket> tickets = new ArrayList<LotteryTicket>();
    private final LotteryTicketGenerator autoTicketGenerator;
    private final LotteryTicketGenerator manualTicketGenerator;

    public LotteryTickets(PurchaseInfo purchaseInfo, LotteryTicketGenerator autoTicketGenerator, LotteryTicketGenerator manualTicketGenerator) {
        this.autoTicketGenerator = autoTicketGenerator;
        this.manualTicketGenerator = manualTicketGenerator;
        generate(purchaseInfo.getAutoCount(), purchaseInfo.getManualCount());
    }

    public List<LotteryTicket> getTickets(){
        return Collections.unmodifiableList(this.tickets);
    }

    private void generate(int autoCount, int manualCount) {
        generateLotteryTickets(manualTicketGenerator, manualCount);
        generateLotteryTickets(autoTicketGenerator, autoCount);
    }

    private void generateLotteryTickets(LotteryTicketGenerator generator, int count) {
        for (int cnt = 0; cnt < count; cnt++){
            tickets.add(generator.generate());
        }
    }
}