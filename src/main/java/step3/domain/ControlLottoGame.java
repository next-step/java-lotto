package step3.domain;

import java.math.BigDecimal;
import java.util.*;

public class ControlLottoGame {

    public BuyLotto startLotto(int totalPrice) {
        LottoInfo lottoInfo = new LottoInfo(1000);
        BuyInfo buyInfo = new BuyInfo(totalPrice, lottoInfo.getLottoPrice());
        Lotto lotto = new Lotto();
        Set<List<Integer>> buyLottoList = new HashSet<>();
        for (int i = 0; i < buyInfo.getTotalCount(); i++) {
            List<Integer> lottoList = lotto.getRandomLottoList();
            buyLottoList.add(lottoList);
        }
        BuyLotto buyLotto = new BuyLotto(buyLottoList);
        return buyLotto;
    }

}
