package step2.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetLottoGame {
    public static Lotto lotto = new Lotto();
    public static BuyInfo buyInfo = new BuyInfo();

    public static BuyInfo startLotto(int totalPrice) {
        int lottoCount = getTotalGame(totalPrice);
        Set<List<Integer>> buyLottoList =  buyLottoList(lottoCount);
        buyInfo.setBuyLottoList(buyLottoList);
        return buyInfo;
    }

    public static Set<List<Integer>> buyLottoList(int lottoCount) {
        Set<List<Integer>> buyLottoList = new HashSet();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoList = lotto.extractLottoNumber();
            buyLottoList.add(lottoList);
        }
        return buyLottoList;
    }

    public static int getTotalGame(int totalPrice) {
        buyInfo = new BuyInfo(totalPrice, Lotto.getPrice());
        return buyInfo.getBuyLottoCount();
    }
}
