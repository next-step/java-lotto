package lotto.presentation.output;

public class EarningRateOutputView {

    public static final String EARNING_RATE_OUTPUT_COMMENT = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)%n";

    public void output(double earningRate) {
        System.out.printf(EARNING_RATE_OUTPUT_COMMENT, earningRate);
    }
}
