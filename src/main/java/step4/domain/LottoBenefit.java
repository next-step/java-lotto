package step4.domain;


import java.util.Map;

public class LottoBenefit {

    private final Map<Rank, Long> matchResult;
    private final long price;

    public LottoBenefit(long price, Map<Rank, Long> matchResult) {
        this.price = price;
        this.matchResult = matchResult;
    }

    public double resultBenefit() {
        double sum = matchResult.entrySet()
                .stream()
                .mapToLong(matchResult ->
                        matchResult.getKey().getWinningMoney() * matchResult.getValue())
                .sum();
        return getCarculatorMoney(price, sum);
    }

    private double getCarculatorMoney(double price, double sum) {
        double result = (sum / price) * 100;
        return Math.floor(result) / 100;
    }

}
