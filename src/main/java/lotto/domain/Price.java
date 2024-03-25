package lotto.domain;

import java.util.Map;
import java.util.Objects;

public class Price {

    private final int price;

    public Price(int price) {
        if (Rule.isNotPaymentSufficientForLotto(price)) {
            throw new IllegalArgumentException(Rule.formatGreaterThanLottoPrice());
        }
        this.price = price;
    }

    public int calculateNumberOfLotto() {
        return price / Rule.LOTTO_PRICE.getValue();
    }

    // integers: 당첨번호와 일치하는 각 등수별 당첨 횟수
    public double calculateRateOfReturn(Map<Prize, Integer> integers) {
        int totalRevenue = calculateTotalRevenue(integers);
        int quotient = calculateQuotient(totalRevenue);
        double secondQuotient = calculateFirstDemicalPlace(quotient);
        double thirdQuotient = calculateThirdDemicalPlace(totalRevenue, secondQuotient);
        return (quotient + secondQuotient + thirdQuotient) * 100 / 100;
    }

    private double calculateThirdDemicalPlace(int totalRevenue, double secondQuotient) {
        return (totalRevenue * 10 - secondQuotient * price) * 10 / price * 0.01;
    }

    private double calculateFirstDemicalPlace(int quotient) {
        return (quotient * 10) / price * 0.1;
    }

    private int calculateQuotient(int totalRevenue) {
        return totalRevenue / price;
    }

    private int calculateTotalRevenue(Map<Prize, Integer> integers) {
        int totalRevenue = 0;
        for (Prize prize : integers.keySet()) {
            totalRevenue += prize.getWinningMoney() * integers.get(prize);
        }
        return totalRevenue;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Price price1 = (Price) object;
        return price == price1.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }

}
