package step2.domain;

import java.util.List;

@FunctionalInterface
public interface NumberGenerateStrategy {
    List<Integer> generate();
}
