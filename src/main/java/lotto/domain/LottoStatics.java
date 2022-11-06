package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class LottoStatics {

    private static final int UNIT_OF_ACCOUNT = 1000;

    public static BigDecimal calculate(List<Lotto> lottoList) {
        validateNull(lottoList);

        BigDecimal sum = lottoList.stream()
                .map(numberList -> numberList.getRank().getAmount()
                        .add(numberList.getRank().getAmount()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal divide = sum.divide(
                BigDecimal.valueOf(2 * UNIT_OF_ACCOUNT * 1000), 2, RoundingMode.HALF_EVEN);

        return divide;
    }

    private static void validateNull(List<Lotto> lottoList) {
        if (lottoList == null) {
            throw new IllegalArgumentException("null 로 들어오면 안된다.");
        }
    }
}
