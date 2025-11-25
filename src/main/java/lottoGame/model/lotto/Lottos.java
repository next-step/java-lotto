package lottoGame.model.lotto;

import java.util.List;
import lottoGame.model.winner.BeforeWinNums;
import lottoGame.model.winner.WinnerResult;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public WinnerResult compareAndElectWinResult(Lotto beforeWinLotto) {
        WinnerResult winnerResult = new WinnerResult();
        for (Lotto lotto : lottos) {
            winnerResult.addWinResult(lotto.checkIfWin(beforeWinLotto));
        }

        return winnerResult;
    }

    public int size() {
        return this.lottos.size();
    }

    public List<String> convertRawString() {
        return this.lottos.stream()
                .map(Lotto::toString)
                .toList();
    }
}
