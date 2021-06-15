package lotto.interfaces;

import lotto.objects.*;

import java.util.ArrayList;
import java.util.List;

public interface Play {
    int buyLotto(int money);
    int getRandomNumber();
    ArrayList<Integer> createLotto();
    Lotto generateLotto();
    WinningType decideWinningType(int count, int bonusNumber, Lotto myLotto);
    WinningType compareBonusNumber(int bonusNumber, Lotto myLotto);
    WinningType findSameNumbers(Lotto initLotto, Lotto myLotto, int bonusBallNumber);
    List<WinningType> getWinningStatistics(Lottos createdLottos, Lotto lastWinningLotto, int bonusBallNumber);
    Lottos autoCreateLottos(int totalLotto);
}
