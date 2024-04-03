package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoVendingMachine {


    private final static int lottoPrice = 1000;

    public List<LottoTicket> receive(int money) {
        validate(money);
        int quantity = getQuantity(money);
        return generate(quantity);
    }

    private static void validate(int money) {
        if (isNotDivided(money)) {
            throw new IllegalArgumentException("1000원 단위의 금액만 사용 가능합니다.");
        }
    }

    private static boolean isNotDivided(int money) {
        return money % 1000 != 0;
    }

    public int getQuantity(int money) {
        return money / lottoPrice;
    }

    public LottoResult match(List<LottoTicket> lottoTickets, LottoTicket lastWeekLotto) {
        return new LottoResult(lottoTickets, lastWeekLotto);
    }

    public List<LottoTicket> generate(int quantity){
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottoTickets.add(LottoTicket.auto());
        }
        return lottoTickets;
    }
}
