package strategy;

import java.util.List;

@FunctionalInterface
public interface NumberGenerator {
    List<Integer> generator();
}
