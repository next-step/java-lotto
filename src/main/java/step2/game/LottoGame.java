package step2.game;

public interface LottoGame {
    int MAX_NUMBER = 45;
    int NUMBER_COUNT = 6;
    int MIN_NUMBER = 1;

    String toString();

    int matchWinningNumberCount(WinningLotto winningLotto);

    boolean containsBonus(WinningLotto winningLotto);
}
