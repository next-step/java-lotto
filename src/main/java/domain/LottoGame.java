package domain;

import java.util.*;

public class LottoGame {

    private LottoMoney money;
    private List<Lotto> userLottos;

    public LottoGame(LottoMoney money, List<Lotto> userLottosByInput) {

        userLottos = new ArrayList<>();

        this.money = money;
        userLottos.addAll(userLottosByInput);

        for (int i = 0 ; i < (money.getNumberOfLotto() - userLottos.size()) ; i++) {
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
