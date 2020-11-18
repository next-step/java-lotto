package lotto.domain.service;

import lotto.domain.repository.Numbers;

@FunctionalInterface
public interface NumberSelectionStrategy {
    Numbers collectNumbers();
}
