package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    private List<Lotto> lottos = null;

    public LottoTicket() {
        this.lottos = new ArrayList<>();
    }

    public void addLotto(List<Lotto> otherLottos) {
        if (otherLottos == null) return;
        lottos.addAll(otherLottos);
    }

    public List<Lotto> getAllLotto(){
        return Collections.unmodifiableList(this.lottos);
    }

    public int getLottoCountByLottoType(Lotto.LottoType type) {
        return lottos.stream()
                .filter(lotto -> lotto.isType(type))
                .collect(Collectors.reducing(0, e -> 1, Integer::sum));
    }
}
