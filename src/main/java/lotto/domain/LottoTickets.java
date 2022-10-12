package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private static final int LOTTO_PRICE = 1000;

    private final int ticket;
    private List<Lotto> lottos = new ArrayList<>();

    private LottoTickets(int money) {
        this.ticket = money / LOTTO_PRICE;
    }

    private LottoTickets(int money, Lotto testResultNumbers) {
        this.ticket = money / LOTTO_PRICE;
        this.lottos.add(testResultNumbers);
    }

    public static LottoTickets from(int money) {
        valid(money);
        return new LottoTickets(money);
    }

    public static LottoTickets from(int money, Lotto testResultNumbers) {
        return new LottoTickets(money, testResultNumbers);
    }

    private static void valid(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException(LOTTO_PRICE + " 미만은 로또를 구매할 수 없습니다.");
        }
    }

    public int countTicket() {
        return this.ticket;
    }

    public List<Lotto> createTickets() {
        for (int i = 0; i < ticket; i++) {
            Lotto generateNumbers = LottoNumberRandomGenerator.generate();
            lottos.add(generateNumbers);
        }
        return lottos;
    }

    public LottoResult calculate(Lotto winningNumbers) {
        LottoResult lottoResult = new LottoResult();
        lottoResult.result(winningNumbers, lottos);
        return lottoResult;
    }

}
