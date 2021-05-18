package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoList;

public class ResultView {

    public void resultBuyPrice(int buyCount) {
        System.out.println(buyCount + "개를 구매했습니다.");
    }

    public void resultLottoList(LottoList lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getAutoLotto());
        }
    }
}
