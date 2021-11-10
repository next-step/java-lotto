package lotto.service;

import java.util.List;

@FunctionalInterface
public interface NumberGenerateStrategy<T> {

    List<T> generate();
}
