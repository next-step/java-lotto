package lotto;

import java.util.Random;

public class Lotto {
    public int buyLotto(int money) {
        return money / 1000;
    }

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(44) + 1;
    }
}
