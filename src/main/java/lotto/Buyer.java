package lotto;

import lotto.controller.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    private static final int LOTTO_PRICE = 1000;

    public int matchPriceAndPayment(int input) {
        return input / LOTTO_PRICE;
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
