package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.util.NumberGenerator;

public class LottoBuy {

    private final int MINIMUM_GAME_COUNT = 1;
    private final int START_NUMBER = 0;
    private final String INVALID_GAME_COUNT = "게임을 시작할 수 없습니다.";

    private final int lottoCount;

    public LottoBuy(Money money) {
        lottoCount = money.divideToMoney();
        validateLottoTryCount(lottoCount);
    }

    private void validateLottoTryCount(int lottoTryCount) {
        if (lottoTryCount < MINIMUM_GAME_COUNT) {
            throw new IllegalArgumentException(INVALID_GAME_COUNT);
        }
    }

    public LottoTicket buyAutoLottos(int lottoCount) {
        List<Lotto> lottoTicket = new ArrayList<>();

        for (int i = START_NUMBER; i < lottoCount; ++i) {
            lottoTicket.add(NumberGenerator.makeAutoLotto());
        }

        return new LottoTicket(lottoTicket);
    }

    public int getCount(){
        return lottoCount;
    }
}
