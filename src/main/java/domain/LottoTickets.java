package domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {
    private final List<Lotto> lottos;

    public LottoTickets() {
        this.lottos = new ArrayList<>();
    }

    public LottoTickets(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public LottoTickets add(LottoTickets tickets) {
        this.lottos.addAll(tickets.lottos);
        return this;
    }

    public static LottoTickets auto(int autoCount) {
        return new LottoTickets(IntStream.range(0, autoCount)
                .mapToObj(i -> new Lotto())
                .collect(Collectors.toList()));
    }

    public static LottoTickets manual(List<Lotto> manualTickets) {
        return new LottoTickets(manualTickets);
    }

}
