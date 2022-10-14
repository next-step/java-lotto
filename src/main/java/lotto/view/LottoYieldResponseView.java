package lotto.view;

import lotto.LottoYield;

public class LottoYieldResponseView implements ResponseView {
    private static final String FORMAT = "총 수익률은 %.2f입니다.";
    private static final String WARNING = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private final LottoYield lottoYield;

    public LottoYieldResponseView(LottoYield lottoYield) {
        this.lottoYield = lottoYield;
    }

    @Override
    public String toView() {
        double yield = lottoYield.calculate();

        String view = String.format(FORMAT, yield);

        if (yield < 1) {
            view += WARNING;
        }

        return view;
    }
}
