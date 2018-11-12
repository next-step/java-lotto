package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGames {

    private final List<Lotto> games = new ArrayList<>();

    public void add(Lotto lotto) {
        games.add(lotto);
    }

    public List<Lotto> getGames() {
        return games;
    }

    public int getAutoGameCount() {
        return (int) games.stream().filter(Lotto::isAutoGame).count();
    }

    public int getManualGameCount() {
        return (int) games.stream().filter(lotto -> !lotto.isAutoGame()).count();
    }
}
