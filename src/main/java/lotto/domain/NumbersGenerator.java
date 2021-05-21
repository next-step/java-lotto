package lotto.domain;

import java.util.List;

@FunctionalInterface
public interface NumbersGenerator {
    List<Integer> generate();
}
