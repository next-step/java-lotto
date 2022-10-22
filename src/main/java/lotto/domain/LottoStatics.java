package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class LottoStatics {

    public static BigDecimal calculate(List<Lotto> lottoList) {

        BigDecimal sum = lottoList.stream()
                .map(x -> x.getRank().getAmount()
                        .add(x.getRank().getAmount()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal divide = sum.divide(
                BigDecimal.valueOf(2 * lottoList.size() * 1000), 2, RoundingMode.HALF_EVEN);

        return divide;
    }
}
