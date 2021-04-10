package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(LottoTicket lottoTicket) {
        this(Collections.singletonList(lottoTicket));
    }

    public LottoTickets(LottoTickets manualLottoTickets, LottoTickets autoLottoTickets) {
        this(combine(manualLottoTickets, autoLottoTickets));
    }

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = new ArrayList<>(lottoTickets);
    }

    public static LottoTickets createBy(int numberOfTicket) {
        LottoTickets autoLottoTickets = new LottoTickets(new ArrayList<>());

        for (int i = 0; i < numberOfTicket; i++) {
            autoLottoTickets.add(new LottoTicket(new LottoNumbers()));
        }

        return autoLottoTickets;
    }

    public static List<LottoTicket> combine(LottoTickets manualLottoTickets, LottoTickets autoLottoTickets) {
        List<LottoTicket> allLottoTickets = new ArrayList<>();
        allLottoTickets.addAll(manualLottoTickets.lottoTickets());
        allLottoTickets.addAll(autoLottoTickets.lottoTickets());

        return allLottoTickets;
    }

    public void add(LottoTicket lottoTicket) {
        lottoTickets.add(lottoTicket);
    }

    public List<LottoTicket> lottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }
}
