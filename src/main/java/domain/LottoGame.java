package domain;

import java.util.*;

public class LottoGame {

    private List<Lotto> userLottos;

    public LottoGame(LottoMoney money) {
        userLottos = new ArrayList<>();
        for(int i = 0 ; i < money.getNumberOfLotto() ; i++) {
            userLottos.add(new Lotto());
        }
    }

    public LottoGame(LottoMoney money, List<Lotto> userLottosByInput) {

        userLottos = new ArrayList<>();

        userLottos.addAll(userLottosByInput);

        for (int i = 0 ; i < (money.getNumberOfLotto() - userLottosByInput.size()) ; i++) {
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

    public int getNumberOfUserLottos() {
        return userLottos.size();
    }

    public List<Lotto> getUserLottos() {
        return userLottos;
    }
}
