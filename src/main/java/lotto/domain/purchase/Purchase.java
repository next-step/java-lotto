package lotto.domain.purchase;

import lotto.domain.lotto.generate.Generate;
import lotto.domain.lotto.ticket.LottoTicket;
import lotto.domain.lotto.ticket.LottoTickets;

public class Purchase {
    private static final String LOTTO_ERROR_MESSAGE = "돈이 부족합니다.";
    private static final int LOTTO_PRICE = 1000;
    private final int money;
    private final Generate lottoGenerate;
    private final LottoTickets lottoTickets;


    public Purchase(int money, Generate lottoGenerate, LottoTickets lottoTickets) {
        this.money = parse(money);
        this.lottoGenerate = lottoGenerate;
        this.lottoTickets = lottoTickets;
    }

    public int purchaseLottoCount() {
        return money / LOTTO_PRICE;
    }

    public LottoTickets purchaseLotto() {
        int lottoPurchaseCounts = purchaseLottoCount();
        for (int i = 0; i < lottoPurchaseCounts; i++) {
            LottoTicket ticket = lottoGenerate.generate();
            add(ticket);
        }

        return this.lottoTickets;
    }

    private void add(LottoTicket ticket) {
        lottoTickets.add(ticket);
    }

    private int parse(int money) {
        if (isValidate(money)) {
            throw new IllegalArgumentException(LOTTO_ERROR_MESSAGE);
        }
        return money;
    }

    private boolean isValidate(int money) {
        return money < LOTTO_PRICE;
    }

}
