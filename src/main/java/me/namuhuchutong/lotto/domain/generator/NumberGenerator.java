package me.namuhuchutong.lotto.domain.generator;

import me.namuhuchutong.lotto.domain.Number;

import java.util.List;

@FunctionalInterface
public interface NumberGenerator {
    List<Number> createNumbers();
}
