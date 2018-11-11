package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int COMBINE_MIN_NUM = 3;
    private static final int LOTTO_PRICE = 1000;

    public static double getTotalEarningRate(int price, int rewards) {
        double result = (double) rewards / (double) price;
        if (price == 0) {
            result = 0;
        }
        return result;
    }

    public static int buyLottoCount(int price) {
        int lottoCount = price / LOTTO_PRICE;
        return lottoCount;
    }


    public static WinningLottoGroup getCombineLottos(LottoGroup lottoGroup, Lotto lastLotto) {
        List<WinningLotto> winningLottos = new ArrayList<>();
        for (Lotto lotto : lottoGroup.getLottoGroup()) {
            if (lotto.getCombineCount(lastLotto) > COMBINE_MIN_NUM) {
                winningLottos.add(lotto.getCombineNumbers(lastLotto));
            }
        }
        return new WinningLottoGroup(winningLottos);
    }
}
