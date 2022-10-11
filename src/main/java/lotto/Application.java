package lotto;

import lotto.domain.*;
import lotto.util.RandomUtils;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

import java.util.List;

/**
 * Created by seungwoo.song on 2022-10-06
 */
public class Application {

    private static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final int LOTTO_NUMBER_COUNT_LIMIT = 45;

    public static void main(String[] args) {
        LottoResultView view = new LottoResultView();

        LottoInputView inputView = new LottoInputView();

        PurchaseInfo purchaseInfo = new PurchaseInfo(LOTTO_PRICE, inputView.readPayAmount());
        LottoFactory lottoFactory = new LottoFactory(new DefaultLottoNumberProduceStrategy(() -> RandomUtils.getNumber(LOTTO_NUMBER_COUNT_LIMIT), LOTTO_NUMBER_COUNT));
        List<Lotto> lotto = lottoFactory.getLotto(purchaseInfo.getCount());

        view.print(lotto);

        LottoStatistic lottoStatistic = new LottoStatistic(inputView.readBeforeLotto(), purchaseInfo, lotto);

        view.print(lottoStatistic);
    }
}
