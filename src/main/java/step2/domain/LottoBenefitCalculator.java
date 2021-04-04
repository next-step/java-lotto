package step2.domain;


import java.util.Map;

public class LottoBenefitCalculator {

    private final Map<Integer, Long> matchResult;
    private final int price;

    public LottoBenefitCalculator(int price, Map<Integer, Long> matchResult) {
        this.price = price;
        this.matchResult = matchResult;
    }

    public double resultBenefit() {
        double sum = matchResult.entrySet()
                .stream()
                .mapToLong(matchResult ->
                        LottoMatchResultCount.of(matchResult.getKey())
                                .getRewardCash(matchResult.getValue()))
                .sum();

        return getCarculatorMoney(price, sum);
    }

    private double getCarculatorMoney(double price, double sum) {
        double result = (sum / price) * 100;
        return Math.floor(result) / 100;
    }

}
