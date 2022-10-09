package lotto.command;

import lotto.domain.Number;

@FunctionalInterface
public interface Command {
    Number execute(Number leftNumber, Number rightNumber);
}
