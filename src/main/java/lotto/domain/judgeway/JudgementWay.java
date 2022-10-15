package lotto.domain.judgeway;

import java.util.function.BiFunction;
import lotto.domain.WinningResult;

public interface JudgementWay extends BiFunction<Integer, WinningResult, Boolean> {
}
