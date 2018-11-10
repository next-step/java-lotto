package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int COMBINE_MIN_NUM = 3;

    public static double getTotalEarningRate(int price, int rewards) {
        double result = (double) rewards / (double) price;
        if (price == 0 || rewards == 0) {
            result = 0;
        }
        return result;
    }

    public static int buyLottoCount(int price) {
        int lottoCount = price / Lotto.LOTTO_PRICE;
        return lottoCount;
    }

    public static LottoGroup getCombineLottos(LottoGroup lottoGroup, Lotto lastLotto) {
        List<Lotto> lottos = new ArrayList<>();
        for (Lotto lotto : lottoGroup.getLottoGroup()) {
            int combineCount = lastLotto.getCombineCount(lotto);
            if (combineCount >= COMBINE_MIN_NUM) {
                lottos.add(lotto);
            }
        }
        return new LottoGroup(lottos);
    }
}
