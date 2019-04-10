package domain;

import java.util.*;

public class LottoGame {

    private List<Lotto> userLottos = new ArrayList<>();

    public LottoGame(LottoMoney money, List<Lotto> userLottosByInput) {
        int manualLottoCount = 0;
        if (userLottosByInput != null) {
            userLottos.addAll(userLottosByInput);
            manualLottoCount = userLottosByInput.size();
        }
        addLottos(money.getNumberOfLotto() - manualLottoCount);
    }


    private void addLottos(int numberOfLottos) {
        for (int i = 0 ; i < numberOfLottos ; i++) {
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
