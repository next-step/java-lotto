package lotto.business;

import lotto.objects.*;

import java.util.*;

public class PlayLotto {
    public int buyLotto(int money) {
        return money / 1000;
    }

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(44) + 1;
    }

    public ArrayList<Integer> createLotto() {
        ArrayList<Integer> lotto = new ArrayList<Integer>();
        for (int i = 0; i < 6; i++) {
            lotto.add(getRandomNumber());
        }

        Collections.sort(lotto);

        return lotto;
    }

    public Lotto generateLotto(Lotto lotto) {
        AllNumbers allNumbers = new AllNumbers();

        List<Integer> randomNumbers = allNumbers.getRandomNumbers();

        for (int i = 0; i < 6; i++) {
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
        for (int i = 0; i < 7; i++) {
            countSameNumbers(initLotto, myLotto, count, i);
        }
        return count.getCount();
    }

    public WinningType decideWinningType(int count, int bonusNumber, Lotto myLotto) {
        if (count == 3) {
            return WinningType.THREE;
        }
        if (count == 4) {
            return WinningType.FOUR;
        }
        if (count == 5) {
            return compareBonusNumber(bonusNumber, myLotto);
        }
        if (count == 6) {
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
        for (int i = 0; i < 6; i++) {
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
