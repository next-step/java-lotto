package study.lotto.controller;

import study.lotto.domain.LottoTicket;
import study.lotto.domain.LottoTicketIssuer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoTicketIssuer implements LottoTicketIssuer {
    private List<Integer> lottoNumberList;

    public RandomLottoTicketIssuer() {
        lottoNumberList = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            lottoNumberList.add(i);
        }
    }

    @Override public LottoTicket issue() {
        Collections.shuffle(lottoNumberList);
        return new LottoTicket(lottoNumberList.subList(0, 6));
    }
}
