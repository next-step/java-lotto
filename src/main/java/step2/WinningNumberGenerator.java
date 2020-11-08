package step2;

import step2.strategy.NumberMakeStrategy;

import java.util.List;

public class WinningNumberGenerator {
    public static List<Integer> create(NumberMakeStrategy numberMakeStrategy){
        return numberMakeStrategy.create();
    }
}
