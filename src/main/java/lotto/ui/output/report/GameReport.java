package lotto.ui.output.report;

import lotto.ui.output.result.GameResult;

public interface GameReport<R extends GameResult> {
    String format(R r);
}
