package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

class PlayLotto {
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

    public static void countSameNumbers(Lotto initLotto, Lotto myLotto, Counter count, int index) {
        if (myLotto.getNumbers().contains(initLotto.getNumbers().get(index))) {
            count.add(1);
        }
    }

    public int compareNumbers(Lotto initLotto, Lotto myLotto) {
        Counter count = new Counter();
        for (int i = 0; i < 7; i++) {
            countSameNumbers(initLotto, myLotto, count, i);
        }
        return count.getCount();
    }

}
