package me.namuhuchutong.lotto;

import java.util.List;

@FunctionalInterface
public interface NumberGenerator {
    List<Number> createNumbers();
}
