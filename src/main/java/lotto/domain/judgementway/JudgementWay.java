package lotto.domain.judgementway;

import java.util.function.BiFunction;
import lotto.domain.WinningResult;

public interface JudgementWay extends BiFunction<Integer, WinningResult, Boolean> {
}
