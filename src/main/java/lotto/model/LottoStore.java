package lotto.model;

import common.view.OutputView;
import lotto.application.Constant;

public class LottoStore {

    private static final int LOTTO_PRICE = 1000;

    private LottoStore() {
    }

    public static Lotto ticket(int purchaseAmount) {

        int lottoCount = purchaseAmount / LOTTO_PRICE;
        OutputView.print(String.valueOf(lottoCount), Constant.OUTPUT_MESSAGE_PURCHASE_LOTTO);

        Lotto lotto = new Lotto(lottoCount);
        OutputView.print(lotto);

        return lotto;
    }

    public static void match(Lotto lotto, LottoWinner winner){
        for (LottoNumbers lottoNumbers : lotto.getLotto()) {
            winner.match(lottoNumbers);
        }
    }

}
