package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoMachine implements RandomBalls{

    private List<Integer> machine;
    private final static int RANDOM_BALL_MIN = 1;
    private final static int RANDOM_BALL_MAX = 45;
    private final static int RANDOM_BALLS_SIZE = 6;

    private void basicNumber() {
        machine = new ArrayList<>();
        for (int i = RANDOM_BALL_MIN; i <= RANDOM_BALL_MAX; i++) {
            machine.add(i);
        }
    }

    public LottoMachine() {
        basicNumber();
    }

    @Override
    public List<Integer> randomBall() {
        Collections.shuffle(machine);
        List<Integer> newLotto = new ArrayList<>();
        for (int i = 0; i < RANDOM_BALLS_SIZE; i++) {
            newLotto.add(machine.get(i));
        }
        Collections.sort(newLotto);
        return newLotto;
    }
}
