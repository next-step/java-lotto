package lotto;

import lotto.model.LottoTicket;
import lotto.model.WinningInfo;

public class LottoGame {

    private static int LOTTO_PRICE = 1000;

    public int getLottoCount(int money) {
        return money / LOTTO_PRICE;
    }

    public int getMatchCount(WinningInfo winningInfo, LottoTicket lottoTicket) {
        return (int) lottoTicket.lotto.stream()
                .distinct()
                .filter(winningInfo.winningLottos::contains)
                .count();
    }

    public boolean containsBonusBall(WinningInfo winningInfo, LottoTicket lottoTicket) {
        return lottoTicket.lotto.contains(winningInfo.bonusNumber);
    }
}
