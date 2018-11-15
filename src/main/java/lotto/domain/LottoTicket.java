package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.Lotto.LottoType;

public class LottoTicket {
    private List<Lotto> lottos = null;

    public LottoTicket(List<Lotto> lottos) {
        super();
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(this.lottos);
    }

    public int getCount() {
        return this.lottos.size();
    }
    
    public int getCount(LottoType type) {
        return lottos.stream()
                .filter(lotto -> type == null || lotto.isType(type) )
                .collect(Collectors.reducing(0, e->1, Integer::sum));
    }
    
    public static LottoTicket of(List<Lotto> lottos) {
        return new LottoTicket(lottos);
    }
    
    public static LottoTicket of(LottoTicket... lottoTickets) {
        return new LottoTicket(mergeLottos(lottoTickets));
    }

    private static List<Lotto> mergeLottos(LottoTicket... lottoTickets) {
        List<Lotto> newLottos = new ArrayList<>();
        for (LottoTicket lottoTicket : lottoTickets) {
            newLottos.addAll(lottoTicket.getLottos());
        }
        return newLottos;
    }

}
