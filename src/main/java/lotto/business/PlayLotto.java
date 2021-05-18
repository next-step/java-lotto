package lotto.business;

import lotto.interfaces.Play;
import lotto.objects.AllNumbers;
import lotto.objects.Counter;
import lotto.objects.Counts;
import lotto.objects.Lotto;
import lotto.objects.Lottos;
import lotto.objects.WinningType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PlayLotto implements Play {
    private static final int PRICE_PER_LOTTO = 1000;
    private static final int NUMBER_COUNT_PER_GAME = 6;
    private static final int MAXIMUM_NUMBER = 45;
    private static final int RANK_FOURTH = 3;
    private static final int RANK_THIRD = 4;
    private static final int RANK_SECOND = 5;
    private static final int RANK_FIRST = 6;

    public int buyLotto(int money) {
        return money / PRICE_PER_LOTTO;
    }

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAXIMUM_NUMBER - 1) + 1;
    }

    public ArrayList<Integer> createLotto() {
        ArrayList<Integer> lotto = new ArrayList<Integer>();
        for (int i = 0; i < NUMBER_COUNT_PER_GAME; i++) {
            lotto.add(getRandomNumber());
        }

        Collections.sort(lotto);

        return lotto;
    }

    public Lotto generateLotto(Lotto lotto) {
        AllNumbers allNumbers = new AllNumbers();

        List<Integer> randomNumbers = allNumbers.getRandomNumbers();

        for (int i = 0; i < NUMBER_COUNT_PER_GAME; i++) {
            lotto.addNumber(randomNumbers.get(i));
        }

        return lotto;
    }

    public static void countSameNumbers(Lotto initLotto, Lotto myLotto, Counter count, int index) {
        if (myLotto.getNumbers().contains(initLotto.getNumbers().get(index))) {
            count.add(1);
        }
    }

    public int compareNumbers(Lotto initLotto, Lotto myLotto) { // not use
        Counter count = new Counter();
        for (int i = 0; i < NUMBER_COUNT_PER_GAME + 1; i++) {
            countSameNumbers(initLotto, myLotto, count, i);
        }
        return count.getCount();
    }

    public WinningType decideWinningType(int count, int bonusNumber, Lotto myLotto) {
        if (count == RANK_FOURTH) {
            return WinningType.THREE;
        }
        if (count == RANK_THIRD) {
            return WinningType.FOUR;
        }
        if (count == RANK_SECOND) {
            return compareBonusNumber(bonusNumber, myLotto);
        }
        if (count == RANK_FIRST) {
            return WinningType.SIX;
        }
        return WinningType.LOSE;
    }

    public WinningType compareBonusNumber(int bonusNumber, Lotto myLotto) {
        if (myLotto.getNumbers().contains(bonusNumber)) {
            return WinningType.FIVE_AND_BONUS;
        }
        return WinningType.FIVE;
    }

    public WinningType findSameNumbers(Lotto initLotto, Lotto myLotto) {
        Counter count = new Counter();
        for (int i = 0; i < NUMBER_COUNT_PER_GAME; i++) {
            countSameNumbers(initLotto, myLotto, count, i);
        }

        return decideWinningType(count.getCount(), initLotto.getNumbers().get(6), myLotto);
    }

    public Counts getWinningStatistics(Lottos createdLottos, Lotto lastWinningLotto) {
        Counts counts = new Counts(Arrays.asList(0, 0, 0, 0, 0));
        for (Lotto lotto : createdLottos.getLottos()) {
            WinningType winningType = findSameNumbers(lastWinningLotto, lotto);

            counts = upCount(winningType, counts);
        }

        return counts;
    }

    public Counts upCount(WinningType winningType, Counts counts) {
        if (winningType == WinningType.THREE) {
            counts.updateCount(0);
        }
        if (winningType == WinningType.FOUR) {
            counts.updateCount(1);
        }
        if (winningType == WinningType.FIVE) {
            counts.updateCount(2);
        }
        if (winningType == WinningType.FIVE_AND_BONUS) {
            counts.updateCount(3);
        }
        if (winningType == WinningType.SIX) {
            counts.updateCount(4);
        }
        return counts;
    }

    public Lottos autoCreateLottos(int totalLotto) {
        Lottos lottos = new Lottos();

        for (int i = 0; i < totalLotto; i++) {
            Lotto lotto = new Lotto();

            lottos.addLotto(generateLotto(lotto));
        }

        return lottos;
    }

}
