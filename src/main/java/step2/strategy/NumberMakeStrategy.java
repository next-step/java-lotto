package step2.strategy;

import java.util.List;

@FunctionalInterface
public interface NumberMakeStrategy {
    List<Integer> create();
}
