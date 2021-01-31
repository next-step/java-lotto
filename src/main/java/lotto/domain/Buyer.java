package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    public int matchPriceAndPayment(int input) {
        return input / 1000;
    }

    public void winningNumberEqual() {

    }

    public void bonusEqual() {

    }

    public void checkEqualWinningNumber() {

    }

    public void winningStatisticalCheck() {

    }

    public void winningRevenueCheck() {

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
