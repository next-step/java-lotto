package domain;

import java.util.*;

public class LottoGame {

    private List<Lotto> userLottos;

    public LottoGame(int lottoCount) {
        userLottos = new ArrayList<>(lottoCount);

        for (int i = 0 ; i < lottoCount ; i++) {
            userLottos.add(new Lotto());
        }
    }

    public LottoGameResult getMultipleResults(WinningLotto winningLotto) {
        LottoGameResult gameResult = new LottoGameResult();
        gameResult.getMultipleResults(winningLotto, userLottos);
        return gameResult;
    }

    public void printUserLottos() {
        System.out.println(userLottos.toString());
    }


}
