package lotto;

import lotto.domain.*;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

import java.util.Collections;
import java.util.List;

/**
 * Created by seungwoo.song on 2022-10-06
 */
public class Application {

    public static void main(String[] args) {
        LottoInputView inputView = new LottoInputView();
        PurchaseInfo purchaseInfo = inputView.read();

        LottoFactory lottoFactory = new LottoFactory();
        LottoResultView view = new LottoResultView();

        List<Lotto> lottos = lottoFactory.produces(Collections::shuffle, purchaseInfo.getAutoLottoCount());
        lottos.addAll(purchaseInfo.getManualLottos());

        view.print(lottos);

        Lotto beforeWinLotto = inputView.readBeforeWinLotto();
        LottoNumber bonusNumber = inputView.readBonusNumber();

        LottoStatistic lottoStatistic = new LottoStatistic();
        lottoStatistic.analyze(lottos, beforeWinLotto, purchaseInfo, bonusNumber);

        view.print(lottoStatistic);
    }
}
