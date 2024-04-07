package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine implements RandomBalls{

    private List<LottoBall> machine;
    private final static int RANDOM_BALL_MIN = 1;
    private final static int RANDOM_BALL_MAX = 45;

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
    public List<LottoBall> randomBall(int ballCount) {
        Collections.shuffle(machine);
        List<LottoBall> newLotto = new ArrayList<>();
        for (int i = 0; i < ballCount; i++) {
            newLotto.add(machine.get(i));
        }
        return newLotto;
    }
}
