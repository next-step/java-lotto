package lotto.service;

import lotto.domain.Numbers;

@FunctionalInterface
public interface NumberSelectionStrategy {
    Numbers collectNumbers();
}
