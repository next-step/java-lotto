package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine implements RandomBalls{

    private List<LottoBall> machine;
    private final static int RANDOM_BALL_MIN = 1;
    private final static int RANDOM_BALL_MAX = 45;
    private final static int RANDOM_BALLS_SIZE = 6;

    private void basicNumber() {
        machine = new ArrayList<>();
        for (int i = RANDOM_BALL_MIN; i <= RANDOM_BALL_MAX; i++) {
            machine.add(LottoBall.ball(i));
        }
    }

    public LottoMachine() {
        this.basicNumber();
    }

    @Override
    public List<LottoBall> randomBall() {
        Collections.shuffle(machine);
        List<LottoBall> newLotto = new ArrayList<>();
        for (int i = 0; i < RANDOM_BALLS_SIZE; i++) {
            newLotto.add(machine.get(i));
        }
        return newLotto;
    }

    @Override
    public List<LottoBall> winBall() {
        Collections.shuffle(machine);
        List<LottoBall> newLotto = new ArrayList<>();
        for (int i = 0; i < RANDOM_BALLS_SIZE + 1; i++) {
            newLotto.add(machine.get(i));
        }
        return newLotto;
    }
}
