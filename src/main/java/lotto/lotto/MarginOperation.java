package lotto.lotto;

import java.util.Map;

@FunctionalInterface
public interface MarginOperation {
    long multiply(Map<LottoMarginCalculator, Integer> map);


}
