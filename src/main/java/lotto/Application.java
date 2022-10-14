package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.LottoStatistic;
import lotto.domain.PurchaseInfo;
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
        PurchaseInfo purchaseInfo = new PurchaseInfo(inputView.readPayAmount());
        LottoFactory lottoFactory = new LottoFactory();
        LottoResultView view = new LottoResultView();

        List<Lotto> lotto = lottoFactory.produces((numbers) -> Collections.shuffle(numbers), purchaseInfo.getCount());

        view.print(lotto);

        Lotto beforeWinLotto = inputView.readBeforeWinLotto();
        int bonusNumber = inputView.readBonusNumber();

        LottoStatistic lottoStatistic = new LottoStatistic();
        lottoStatistic.analyze(lotto, beforeWinLotto, purchaseInfo, bonusNumber);

        view.print(lottoStatistic);
    }
}
