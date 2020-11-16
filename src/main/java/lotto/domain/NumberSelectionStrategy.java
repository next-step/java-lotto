package lotto.domain;

@FunctionalInterface
public interface NumberSelectionStrategy {
    Numbers collectNumbers();
}
