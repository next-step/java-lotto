package lotto.domain;

import java.math.BigDecimal;

public class Stats {
    Prize prize;
    BigDecimal totalWinningMoney;
    double yield;

    public Stats(Prize prize) {
        this.prize = prize;
    }

    public BigDecimal getTotalMoney() {
        return totalWinningMoney;
    }

    private BigDecimal calTotalWinningMoney() {
        totalWinningMoney = new BigDecimal("0");
        for (Rank type : Rank.values()) {
            BigDecimal count = BigDecimal.valueOf(prize.getPrize().get(type));
            BigDecimal unit = BigDecimal.valueOf(type.getMoney());
            BigDecimal round = count.multiply(unit);
            totalWinningMoney = totalWinningMoney.add(round);
        }
        return totalWinningMoney;
    }

    public double calYield(int totalPrice) {
        yield = calTotalWinningMoney().doubleValue()/totalPrice;
        return yield;
    }
}
