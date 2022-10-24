package lotto.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoTickets {

    public static final int LOTTO_PRICE = 1000;

    private List<Lotto> lottos;

    private LottoTickets(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoTickets of(List<Lotto> lottos) {
        return new LottoTickets(lottos);
    }

    public static LottoTickets of(int money) {
        int tickets = countTicket(money);
        return new LottoTickets(createTickets(tickets));
    }

    public static LottoTickets of(OrderInformation orderInformation) {
        int tickets = orderInformation.countAutoTickets();
        List<Lotto> randomLottos = createTickets(tickets);
        List<Lotto> lottos = Stream.of(orderInformation.getManualLottos(), randomLottos)
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
        return new LottoTickets(lottos);
    }

    private static int countTicket(int money) {
        return Money.from(money).getMoney() / LOTTO_PRICE;
    }

    public int getTicketCount() {
        return lottos.size();
    }

    private static List<Lotto> createTickets(int tickets) {
        return IntStream.range(0, tickets)
            .mapToObj(i -> LottoRandomGenerator.generate()).collect(Collectors.toList());
    }

    public List<Lotto> getTickets() {
        return new ArrayList<>(lottos);
    }

    public LottoResult getResult(WinningLotto winningLotto) {
        LottoResult lottoResult = new LottoResult();
        lottoResult.result(winningLotto, LottoTickets.of(lottos));
        return lottoResult;
    }
}
