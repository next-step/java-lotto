package lottoauto.domain.lotto;

import lottoauto.domain.aggregate.WinnerBoard;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottoList;
    private final int lottoCount;

    public static final int EACH_LOTTO_PRICE = 1000;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
        this.lottoCount = lottoList.size();
    }

    public void checkWinnerLotto(WinnerBoard winnerBoard, List<Integer> winNumbers) {
        for (Lotto lotto : lottoList) {
            int winNumber = lotto.getLottoScore(winNumbers);
            winnerBoard.updateWinningLottoCount(winNumber);
        }
    }

    public int totalLottoBuyMoney() {
        return lottoCount * EACH_LOTTO_PRICE;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
