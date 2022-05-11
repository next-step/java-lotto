package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LotteryGames {
    private List<LotteryGame> lotteryGames;

    public LotteryGames() {
        this.lotteryGames = new ArrayList<>();
    }

    public LotteryGames(List<LotteryGame> lotteryGames) {
        this.lotteryGames = lotteryGames;
    }

    public LotteryGames create(int number) {
        for (int i = 0; i < number; i++) {
            LotteryGame lotteryGame = new LotteryGame().create();
            lotteryGames.add(lotteryGame);
        }
        return new LotteryGames(lotteryGames);
    }

    public List<LotteryGame> getLotteryGames() {
        return lotteryGames;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (LotteryGame lotteryGame : lotteryGames) {
            stringBuilder.append(lotteryGame).append("\n");
        }
        return stringBuilder.toString();
    }
}
