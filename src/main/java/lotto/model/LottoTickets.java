package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.groupingBy;

public class LottoTickets {

    private final List<LottoTicket> manualLottoTickets;
    private final List<LottoTicket> autoLottoTickets;

    public LottoTickets(List<LottoTicket> manualLottoTickets, List<LottoTicket> autoLottoTickets) {
        this.manualLottoTickets = unmodifiableList(manualLottoTickets);
        this.autoLottoTickets = unmodifiableList(autoLottoTickets);
    }

    public Map<Rank, Long> getRankMap(LottoTicket winningNumbers, LottoNumber bonusBall){
        return getMergedLottoTickets().stream()
                .map(ticket -> ticket.getRank(winningNumbers, bonusBall))
                .filter(Rank::isWin)
                .collect(groupingBy(Function.identity(), Collectors.counting()));
    }

    public List<LottoTicket> getMergedLottoTickets(){
        List<LottoTicket> merged = new ArrayList<>();
        merged.addAll(manualLottoTickets);
        merged.addAll(autoLottoTickets);
        return merged;
    }


    public int getManualLottoSize() {
        return manualLottoTickets.size();
    }

    public int getAutoTicketSize() {
        return autoLottoTickets.size();
    }
}
