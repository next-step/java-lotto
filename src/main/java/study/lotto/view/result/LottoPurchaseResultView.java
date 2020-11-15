package study.lotto.view.result;

import study.lotto.core.Lotto;
import study.lotto.view.AbstractView;

import java.util.List;

public class LottoPurchaseResultView extends AbstractView {

    private static final LottoPurchaseResultView instance = new LottoPurchaseResultView();

    public static LottoPurchaseResultView getInstance() {
        return instance;
    }

    public void display(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            stringBuilder.append(lotto.toString());
            printAndClear();
        }
    }
}
