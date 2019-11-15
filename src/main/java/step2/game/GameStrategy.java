package step2.game;

import step2.analyze.WinningCount;
import step2.numbers.WinningLotto;

public interface GameStrategy {

    void checkWinningCount(WinningCount winningCount, WinningLotto winningLotto);

    int size();

    String toString(int index);
}