package lotto.domain;

import lotto.dto.WinningResult;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

public class Winnings {
    public static final int LOTTO_PRICE = 1000;
    public static final int TWO_DECIMAL_PLACE = 2;

    private final List<Winning> winnings;

    public Winnings(final List<Winning> winnings) {
        this.winnings = winnings;
    }

    public WinningResult result(final List<Lotto> lottos) {
        int sum = winnings.stream()
                .mapToInt(Winning::price)
                .sum();
        BigDecimal sumPrice = new BigDecimal(sum);
        BigDecimal totalPrice = new BigDecimal(lottos.size() * LOTTO_PRICE);

        BigDecimal totalReturn = sumPrice.divide(totalPrice, TWO_DECIMAL_PLACE, RoundingMode.DOWN);
        return new WinningResult(winnings, totalReturn);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Winnings winnings1 = (Winnings) o;
        return Objects.equals(winnings, winnings1.winnings);
    }
}
