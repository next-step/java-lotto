package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {

    private static final int LOTTO_PRICE = 1000;

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

    private static void valid(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException(LOTTO_PRICE + " 미만은 로또를 구매할 수 없습니다.");
        }
    }

    private static int countTicket(int money) {
        valid(money);
        return money / LOTTO_PRICE;
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
