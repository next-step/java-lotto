package lotto.domain;

import java.util.List;

public class LottoTickets {

    private static final int LOTTO_PRICE = 1000;

    private List<Lotto> lottos;

    private LottoTickets(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoTickets of(List<Lotto> lottos) {
        return new LottoTickets(lottos);
    }

    private static void valid(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException(LOTTO_PRICE + " 미만은 로또를 구매할 수 없습니다.");
        }
    }

    public int countTicket(int money) {
        valid(money);
        return money / LOTTO_PRICE;
    }

    public List<Lotto> createTickets(int tickets) {
        for (int i = 0; i < tickets; i++) {
            Lotto generateNumbers = LottoNumberRandomGenerator.generate();
            lottos.add(generateNumbers);
        }
        return lottos;
    }

    public LottoResult calculate(Lotto winningNumbers, int bonusBall) {
        LottoResult lottoResult = new LottoResult();
        lottoResult.result(winningNumbers, lottos, bonusBall);
        return lottoResult;
    }

}
