package lotto.presentation.output;

import lotto.domain.EarningRate;

public class EarningRateOutputView {

    private static final String EARNING_RATE_OUTPUT_COMMENT = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)%n";

    public void output(EarningRate earningRate) {
        System.out.printf(EARNING_RATE_OUTPUT_COMMENT, earningRate.getValue());
    }
}
