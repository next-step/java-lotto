package lotto.interfaces;

import lotto.objects.*;

import java.util.ArrayList;

public interface Play {
    int buyLotto(int money);
    int getRandomNumber();
    ArrayList<Integer> createLotto();
    Lotto generateLotto(Lotto lotto);
    int compareNumbers(Lotto initLotto, Lotto myLotto);
    WinningType decideWinningType(int count, int bonusNumber, Lotto myLotto);
    WinningType compareBonusNumber(int bonusNumber, Lotto myLotto);
    WinningType findSameNumbers(Lotto initLotto, Lotto myLotto);
    Counts getWinningStatistics(Lottos createdLottos, Lotto lastWinningLotto);
    Counts upCount(WinningType winningType, Counts counts);
    Lottos autoCreateLottos(int totalLotto);
}
