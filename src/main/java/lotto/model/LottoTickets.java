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
        validate(manualLottoTickets, autoLottoTickets);
        this.manualLottoTickets = unmodifiableList(manualLottoTickets);
        this.autoLottoTickets = unmodifiableList(autoLottoTickets);
    }

    public void validate(List<LottoTicket> manualLottoTickets, List<LottoTicket> autoLottoTickets){
        if(manualLottoTickets == null || autoLottoTickets == null){
            throw new IllegalArgumentException("로또 티켓리스트가 널값입니다.");
        }
    }

    public LottoResult getRankMap(LottoTicket winningNumbers, LottoNumber bonusBall){
        return new LottoResult(getMergedLottoTickets().stream()
                .map(ticket -> ticket.getRank(winningNumbers, bonusBall))
                .filter(Rank::isWin)
                .collect(groupingBy(Function.identity(), Collectors.counting())));
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
