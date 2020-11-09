package step2;

import step2.domain.lotto.WinningNumber;
import step2.strategy.NumberMakeStrategy;

import java.util.List;

public class WinningNumberGenerator {
    public static WinningNumber create(NumberMakeStrategy numberMakeStrategy){
        List<Integer> integers = numberMakeStrategy.create();
        return WinningNumber.of(integers);
    }
}
