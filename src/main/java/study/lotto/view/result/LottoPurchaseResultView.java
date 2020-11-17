package study.lotto.view.result;

import study.lotto.core.Lotto;
import study.lotto.core.LottoNumber;
import study.lotto.dispenser.Lottos;
import study.lotto.view.AbstractView;

import java.util.stream.Collectors;

public class LottoPurchaseResultView extends AbstractView {

    private static final LottoPurchaseResultView instance = new LottoPurchaseResultView();

    public static LottoPurchaseResultView getInstance() {
        return instance;
    }

    public void display(Lottos lottos) {
        for (Lotto lotto : lottos) {
            stringBuilder.append(toLottoView(lotto));
            printAndClear();
        }
    }

    private String toLottoView(Lotto lotto) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        String lottoNumbersString = lotto.getLottoNumbers().stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(", "));

        stringBuilder.append(lottoNumbersString);
        stringBuilder.append("]");

        return stringBuilder.toString();
    }

}
