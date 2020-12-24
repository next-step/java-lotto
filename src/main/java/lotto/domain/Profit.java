package lotto.domain;

public class Profit {

    private final double ratio;
    private String profitText = "기준이 1이기 때문에 결과적으로 손해라는 의미임";

    public Profit(double ratio) {
        if (ratio < 0 || Double.isNaN(ratio)) {
            throw new IllegalArgumentException();
        }
        this.ratio = ratio;
        if (ratio > 1) {
            profitText = "기준이 1이기 때문에 결과적으로 이익이라는 의미임";
        }
    }

    public String toFormattingSting() {
        return String.format("총 수익률은 %1.2f입니다.(%s)%n", ratio, profitText);
    }

}