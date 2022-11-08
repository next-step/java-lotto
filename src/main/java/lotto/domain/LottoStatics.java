package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class LottoStatics {

    private static final int UNIT_OF_ACCOUNT = 1000;    // 1000원
    private static final int PERCENT = 100;             // 100%

    public static BigDecimal calculate(List<Lotto> lottoList) {
        validateNull(lottoList);
        return divideOfListCount(sumOfLottoList(lottoList), lottoList.size());
    }

    private static BigDecimal sumOfLottoList(List<Lotto> lottoList) {
        return lottoList.stream()
                .map(Lotto::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private static BigDecimal divideOfListCount(BigDecimal sum, int count) {
        return sum.divide(BigDecimal.valueOf(UNIT_OF_ACCOUNT * PERCENT * count), 2, RoundingMode.HALF_EVEN);
    }

    private static void validateNull(List<Lotto> lottoList) {
        if (lottoList == null) {
            throw new IllegalArgumentException("null 로 들어오면 안된다.");
        }
    }
}
