package lotto.command;

import lotto.domain.Number;

public interface Command {
    Number execute(Number leftNumber, Number rightNumber);

    String operator();
}
