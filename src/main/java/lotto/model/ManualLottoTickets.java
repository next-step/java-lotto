package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class ManualLottoTickets {

    private List<ManualLottoTicket> manualLottoTickets;

    public ManualLottoTickets(List<ManualLottoTicket> manualLottoTickets) {
        this.manualLottoTickets = new ArrayList<>(manualLottoTickets);
    }

    public static ManualLottoTickets create(List<ManualLottoTicket> manualLottoTickets) {
        return new ManualLottoTickets(manualLottoTickets);
    }

    public int size() {
        return manualLottoTickets.size();
    }

    public List<ManualLottoTicket> getManualLottoTickets() {
        return manualLottoTickets;
    }
}
