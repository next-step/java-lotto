package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoTicket {

    private final List<Lotto> lottos;

    private LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoTicket of(List<Lotto> lottos) {
        return new LottoTicket(lottos);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public Matches getMatches(WinningLotto winningLotto) {
        return Matches.of(lottos.stream()
                .map(winningLotto::getMatch)
                .filter(Objects::nonNull)
                .collect(Collectors.toList()));
    }
}
