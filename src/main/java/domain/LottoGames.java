package domain;

import domain.winningStatus.GeneralWinningStatus;
import domain.winningStatus.WinningStatus;

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

    public WinningStatus match(WinningNumber winningNumber) {
        WinningStatus winningStatus = new GeneralWinningStatus();

        for (Lotto lotto : games) {
            winningStatus.putPrize(winningNumber.match(lotto));
        }

        return winningStatus;
    }
}
