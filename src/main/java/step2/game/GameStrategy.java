package step2.game;

import step2.numbers.LottoGame;

import java.util.List;

public interface GameStrategy {
    List<LottoGame> getGames();

    int size();

    String toString(int index);
}