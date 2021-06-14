package lotto;

import java.util.*;
import static lotto.LottoConstant.*;

public class LottoCreater {
    private List<LottoTicket> lottoTickets;

    public LottoCreater(int money){
        lottoTickets = new ArrayList<>();
        buyLotto(money);
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    private List<LottoTicket> buyLotto(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또를 구입할 금액이 부족합니다.");
        }
        return generateLottoTickets(money / LOTTO_PRICE);
    }

    private List<LottoTicket> generateLottoTickets(int count) {
        for(int i = 0; i < count; i++) {
            lottoTickets.add(new LottoTicket());
        }
        return lottoTickets;
    }

}
