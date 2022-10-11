package lotto;

import lotto.domain.*;
import lotto.util.RandomUtils;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

import java.util.List;

import static lotto.domain.LottoNumberProduceStrategy.*;
import static lotto.domain.PurchaseInfo.*;

/**
 * Created by seungwoo.song on 2022-10-06
 */
public class Application {

    public static void main(String[] args) {
        LottoInputView inputView = new LottoInputView();
        PurchaseInfo purchaseInfo = new PurchaseInfo(LOTTO_PRICE, inputView.readPayAmount());
        LottoFactory lottoFactory = new LottoFactory();
        LottoResultView view = new LottoResultView();

        List<Lotto> lotto = lottoFactory.produces(() -> RandomUtils.getNumber(MAX_LOTTO_NUMBER), purchaseInfo.getCount());

        view.print(lotto);

        LottoStatistic lottoStatistic = new LottoStatistic(inputView.readBeforeLotto(), purchaseInfo, lotto);

        view.print(lottoStatistic);
    }
}
