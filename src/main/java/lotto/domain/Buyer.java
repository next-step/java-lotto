package lotto.domain;

import lotto.controller.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    public int matchPriceAndPayment(int input) {
        return input / 1000;
    }

    public List<LottoTicket> buyLotto(int input) {
        List<LottoTicket> lottos = new ArrayList<>();
        int lottoCnt = matchPriceAndPayment(input);
        for (int i = 0; i < lottoCnt; i++) {
            lottos.add(LottoGenerator.generateLotto(i));
        }
        return lottos;
    }
}
